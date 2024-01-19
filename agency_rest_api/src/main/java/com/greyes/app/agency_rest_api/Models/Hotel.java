package com.greyes.app.agency_rest_api.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private int stars;
	
	@Column
	private String country;
	
	@Column
	private String city;
	
	@Column
	private String street;
	
	@Column
	private int street_number;
	
	@Column
	private String disponibility_endpoint;
	
	@Column
	private String reservation_endpoint;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}

	public String getDisponibility_endpoint() {
		return disponibility_endpoint;
	}

	public void setDisponibility_endpoint(String disponibility_endpoint) {
		this.disponibility_endpoint = disponibility_endpoint;
	}

	public String getReservation_endpoint() {
		return reservation_endpoint;
	}

	public void setReservation_endpoint(String reservation_endpoint) {
		this.reservation_endpoint = reservation_endpoint;
	}

}
