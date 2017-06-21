package edu.mum.coffee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull(message = "{NotNull.Person.address.city.validation}")
	private String city;
	
	@NotNull(message = "{NotNull.Person.address.state.validation}")
	private String state;
	
	@NotNull(message = "{NotNull.Person.address.country.validation}")
	private String country;
	
	@NotNull(message = "{NotNull.Person.address.zipcode.validation}")
	@Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "{Pattern.address.zipcode.validation}")
	private String zipcode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", zipcode="
				+ zipcode + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
