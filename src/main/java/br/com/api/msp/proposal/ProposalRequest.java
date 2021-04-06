package br.com.api.msp.proposal;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.api.msp.address.Address;
import br.com.api.msp.address.AddressRequest;
import br.com.api.msp.validation.CPForCNPJ;

public class ProposalRequest {

	@NotBlank
	@CPForCNPJ(message = "O documento deve ser válido!")
	private String document;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String name;

	@NotNull
	@Valid
	private AddressRequest address;

	@NotNull
	@PositiveOrZero
	private BigDecimal salary;

	@Deprecated
	public ProposalRequest() {
	}

	public ProposalRequest(@NotBlank String document, @NotBlank String email, @NotBlank String name,
			@NotBlank AddressRequest address, @NotNull @PositiveOrZero BigDecimal salary) {
		this.document = document;
		this.email = email;
		this.name = name;
		this.address = address;
		this.salary = salary;
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

	public AddressRequest getAddress() {
		return address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Proposal toModel() {

		Address address = this.address.toModel();

		return new Proposal(document, email, name, address, salary);
	}

}
