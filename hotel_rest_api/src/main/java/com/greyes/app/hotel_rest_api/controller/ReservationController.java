package com.greyes.app.hotel_rest_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyes.app.hotel_rest_api.model.Agency;
import com.greyes.app.hotel_rest_api.model.Customer;
import com.greyes.app.hotel_rest_api.model.Reservation;
import com.greyes.app.hotel_rest_api.repository.AgencyRepository;
import com.greyes.app.hotel_rest_api.repository.CustomerRepository;
import com.greyes.app.hotel_rest_api.repository.ReservationRepository;
import com.greyes.app.hotel_rest_api.repository.RoomRepository;
import com.greyes.app.hotel_rest_api.requests.ReservationRequest;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	public AgencyRepository agencyRepo;
	
	@Autowired
	public CustomerRepository customerRepo;
	
	@Autowired
	public RoomRepository roomRepo;

	@PostMapping(value = "/")
	public Reservation createReservation(@RequestBody ReservationRequest reservationRequest){
		
		Optional<Agency> agency = agencyRepo.findByLoginAndPassword(reservationRequest.getAgency_login(), reservationRequest.getAgency_password());
		if (agency.isEmpty()) return null;
		
		for (Reservation reservation : reservationRepo.findAllByRoom(roomRepo.findById(reservationRequest.getRoom_id()).get())) {	
			if ((reservation.getArrived().compareTo(reservationRequest.getDeparture()) <= 0) && (reservation.getDeparture().compareTo(reservationRequest.getArrival()) >= 0)) {
				return null;
			}
		}
		
		Optional<Customer> o_customer = customerRepo.findByFirstNameAndLastName(reservationRequest.getFirstName(), reservationRequest.getLastName());
		Customer customer = null;
		if (o_customer.isEmpty()) {
			customer = new Customer();
			customer.setFirstName(reservationRequest.getFirstName());
			customer.setLastName(reservationRequest.getLastName());
			customer = customerRepo.save(customer);
		}
		else {
			customer = o_customer.get();
		}
		
		Reservation reservation = new Reservation();
		reservation.setArrived(reservationRequest.getArrival());
		reservation.setDeparture(reservationRequest.getDeparture());
		reservation.setAgency(agency.get());
		reservation.setCustomer(customer);
		reservation.setRoom(roomRepo.findById(reservationRequest.getRoom_id()).get());
		reservation.setConfirmation(true);
		
		reservation = reservationRepo.save(reservation);
		
		
		return reservation;
	}
	
}
