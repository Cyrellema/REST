package com.greyes.app.agency_rest_api.RequestsAndReponses;

import java.sql.Timestamp;

public class FindRequest {
	
	private Timestamp arrival;
	private Timestamp departure;
	private String city;
	private int stars;
	private double minPrice;
	private double maxPrice;
	private int bedsWanted;

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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getBedsWanted() {
		return bedsWanted;
	}
	public void setBedsWanted(int bedsWanted) {
		this.bedsWanted = bedsWanted;
	}

}
