package com.greyes.app.agency_rest_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyes.app.agency_rest_api.Models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	List<Hotel> findByCityAndStars(String city, int stars);

}
