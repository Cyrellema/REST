package com.greyes.app.hotel_rest_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyes.app.hotel_rest_api.model.Reservation;
import com.greyes.app.hotel_rest_api.model.Room;


public interface ReservationRepository extends JpaRepository<Reservation,Long>{

	Optional<Reservation> findById(Long id);
	
	List<Reservation> findAll();
	
	List<Reservation> findAllByRoom(Room room);
}
