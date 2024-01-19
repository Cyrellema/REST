package com.greyes.app.comparator_rest_api.RequestsAndReponses;

public class FindRequest {
	
	private String city;
	private int stars;
	private double minPrice;
	private double maxPrice;
	private int bedsWanted;

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
