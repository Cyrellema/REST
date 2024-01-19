package com.greyes.app.agency_rest_api.RequestsAndReponses;

import java.util.List;

import com.greyes.app.agency_rest_api.Models.Hotel;

public class FindResponse {
	
	private List<Object> offers;
	private Hotel hotel;

	public FindResponse(List<Object> offers, Hotel hotel) {
		super();
		this.offers = offers;
		this.hotel = hotel;
	}

	public List<Object> getOffers() {
		return offers;
	}
	public void setOffers(List<Object> offers) {
		this.offers = offers;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	

}
