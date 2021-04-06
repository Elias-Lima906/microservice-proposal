package br.com.api.msp.proposal;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.api.msp.address.Address;
import br.com.api.msp.address.AddressResponse;

@Entity
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	@NotBlank
	private String document;

	@Column(nullable = false)
	@NotBlank
	private String email;

	@Column(nullable = false)
	@NotBlank
	private String name;

	@NotNull
	@Embedded
	private Address address;

	@Column(nullable = false)
	@NotNull
	@PositiveOrZero
	private BigDecimal salary;

	@Deprecated
	public Proposal() {
	}

	public Proposal(@NotBlank String document, @NotBlank String email, @NotBlank String name, @NotNull Address address,
			@NotNull @PositiveOrZero BigDecimal salary) {
		this.document = document;
		this.email = email;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public String getDocument() {
		return document;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public static Proposal findById(Long id, ProposalRepository repository) {
		Optional<Proposal> proposal = repository.findById(id);

		if (proposal.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não foi encontrado, em sua conta, nenhuma proposta com o id: " + id);
		}

		return proposal.get();
	}

	public boolean checkDocumentExistence(ProposalRepository repository) {
		if (repository.existsByDocument(document)) {
			return true;
		}
		return false;
	}

	public AddressResponse addressResponse() {
		return this.address.toAddressDto();
	}

}
