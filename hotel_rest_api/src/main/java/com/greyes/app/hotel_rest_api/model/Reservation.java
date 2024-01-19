package com.greyes.app.hotel_rest_api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="customer",referencedColumnName="id",nullable=false,unique=true)
	    private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="agency_id",referencedColumnName="id",nullable=false,unique=true)
	    private Agency agency;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="room",referencedColumnName="id",nullable=false,unique=true)
	    private Room room;
	 
	@Column(name="confirmation")
		private boolean confirmation;
	
	@Column(name="arrived")
		private Timestamp arrived;
		
	@Column(name="departure")
		private Timestamp departure;
	
	public Reservation() {
		
	}
	
	public Reservation(Room room, Customer customer, Agency agency) {
		this.room=room;
		this.customer=customer;
		this.agency=agency;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Timestamp getArrived() {
		return arrived;
	}

	public void setArrived(Timestamp arrived) {
		this.arrived = arrived;
	}

	public Timestamp getDeparture() {
		return departure;
	}

	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}
