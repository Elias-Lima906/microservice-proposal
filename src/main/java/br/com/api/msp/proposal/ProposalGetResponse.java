package br.com.api.msp.proposal;

import java.math.BigDecimal;

import br.com.api.msp.address.AddressResponse;

public class ProposalGetResponse {

	private String document;
	private String email;
	private String name;
	private AddressResponse address;
	private BigDecimal salary;

	@Deprecated
	public ProposalGetResponse() {
	}

	public ProposalGetResponse(Proposal proposal) {
		this.document = proposal.getDocument();
		this.email = proposal.getEmail();
		this.name = proposal.getName();
		this.address = proposal.addressResponse();
		this.salary = proposal.getSalary();
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

	public AddressResponse getAddress() {
		return address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

}
