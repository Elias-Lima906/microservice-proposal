package br.com.api.msp.proposal;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

	@Autowired
	private ProposalRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> saveProposal(@RequestBody @Valid ProposalRequest request,
			UriComponentsBuilder uriComponentsBuilder) {

		@Valid
		Proposal proposal = request.toModel();

		if (proposal.checkDocumentExistence(repository)) {
			return ResponseEntity.unprocessableEntity().build();
		}

		repository.save(proposal);

		return ResponseEntity.created(location(uriComponentsBuilder, proposal))
				.body(new ProposalPostResponse(proposal.getId(), "Criado com sucesso!"));
	}

	@GetMapping(path = "/{id}")
	public ProposalGetResponse getProposalById(@PathVariable Long id) {
		Proposal proposal = Proposal.findById(id, repository);
		return new ProposalGetResponse(proposal);
	}

	private URI location(UriComponentsBuilder uriComponentsBuilder, Proposal proposal) {
		return uriComponentsBuilder.path("/proposals/{id}").buildAndExpand(proposal.getId()).toUri();
	}
}
