package br.com.api.msp.proposal;

public class ProposalPostResponse {

	private Long id;
	private String message;

	@Deprecated
	public ProposalPostResponse() {
	}

	public ProposalPostResponse(Long id, String message) {
		this.id = id;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

}
