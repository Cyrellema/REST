package com.greyes.app.hotel_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyes.app.hotel_rest_api.model.Room;



public interface RoomRepository extends JpaRepository<Room,Long> {
	
	
	
	//public List<Room> findByDisponbility();

	public List<Room> findByBeds(int beds);
	
	public List<Room> findByPrice(double price);

}
