package com.greyes.app.comparator_rest_api.RequestsAndReponses;

import com.greyes.app.comparator_rest_api.Models.Agency;

public class FindResponse {
	
	private Agency agency;
	private Object hotel_offers;

	public FindResponse(Agency agency, Object hotel_offers) {
		super();
		this.agency = agency;
		this.hotel_offers = hotel_offers;
	}

	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public Object getHotel_offers() {
		return hotel_offers;
	}
	public void setHotel_offers(Object hotel_offers) {
		this.hotel_offers = hotel_offers;
	}

}
