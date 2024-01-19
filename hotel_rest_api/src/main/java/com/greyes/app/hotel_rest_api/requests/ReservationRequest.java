package com.greyes.app.hotel_rest_api.requests;

import java.sql.Timestamp;

public class ReservationRequest {
	
	private long room_id;
	private Timestamp arrival;
	private Timestamp departure;
	private String agency_login;
	private String agency_password;
	private String firstName;
	private String lastName;

	public long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}
	public Timestamp getArrival() {
		return arrival;
	}
	public void setArrival(Timestamp arrival) {
		this.arrival = arrival;
	}
	public Timestamp getDeparture() {
		return departure;
	}
	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}
	public String getAgency_login() {
		return agency_login;
	}
	public void setAgency_login(String agency_login) {
		this.agency_login = agency_login;
	}
	public String getAgency_password() {
		return agency_password;
	}
	public void setAgency_password(String agency_password) {
		this.agency_password = agency_password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
