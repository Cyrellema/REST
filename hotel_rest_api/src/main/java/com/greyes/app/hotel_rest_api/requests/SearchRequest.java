package com.greyes.app.hotel_rest_api.requests;

public class SearchRequest {
	private int bedsWanted;
	private double minPrice;
	private double maxPrice;
	private String agency_login;
	private String agency_password;
	
	public int getBedsWanted() {
		return bedsWanted;
	}
	public void setBedsWanted(int bedsWanted) {
		this.bedsWanted = bedsWanted;
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

}
