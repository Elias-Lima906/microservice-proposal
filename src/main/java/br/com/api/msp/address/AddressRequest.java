package br.com.api.msp.address;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

@Embeddable
public class AddressRequest {

	@NotBlank
	private String city;

	@NotBlank
	private String neighborhood;

	@NotBlank
	private String address;

	@NotBlank
	@Size(max = 9)
	private String zipCode;

	@Nullable
	private String complement;

	@Deprecated
	public AddressRequest() {
	}

	public AddressRequest(@NotBlank String city, @NotBlank String neighborhood, @NotBlank String address,
			@NotBlank @Size(max = 9) String zipCode, String complement) {
		super();
		this.city = city;
		this.neighborhood = neighborhood;
		this.address = address;
		this.zipCode = zipCode;
		this.complement = complement;
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

	public Address toModel() {
		return new Address(city, neighborhood, address, zipCode, complement);
	}

}
