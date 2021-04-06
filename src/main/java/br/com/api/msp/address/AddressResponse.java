package br.com.api.msp.address;

import javax.persistence.Embeddable;

@Embeddable
public class AddressResponse {

	private String city;
	private String neighborhood;
	private String address;
	private String zipCode;
	private String complement;

	@Deprecated
	public AddressResponse() {
	}

	public AddressResponse(Address address) {
		super();
		this.city = address.getCity();
		this.neighborhood = address.getNeighborhood();
		this.address = address.getAddress();
		this.zipCode = address.getZipCode();
		this.complement = address.getComplement();
	}

	public String getCity() {
		return city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getComplement() {
		return complement;
	}

}
