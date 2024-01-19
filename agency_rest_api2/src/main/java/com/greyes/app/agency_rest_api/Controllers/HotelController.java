package com.greyes.app.agency_rest_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyes.app.agency_rest_api.Models.Hotel;
import com.greyes.app.agency_rest_api.Repositories.HotelRepository;

@RequestMapping(value = "hotels")
@RestController
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepo;
	
	@GetMapping(value = "/")
	public List<Hotel> getHotels(){
		return hotelRepo.findAll();
	}
	
	@PostMapping(value = "/")
	public String saveHotel(@RequestBody Hotel hotel) {
		hotelRepo.save(hotel);
		return "Saved...";
	}
	
	@PutMapping(value = "/{id}")
	public String updateHotel(@PathVariable long id, @RequestBody Hotel hotel) {
		Hotel updatedHotel = hotelRepo.findById(id).get();
		updatedHotel.setName(hotel.getName());
		updatedHotel.setStars(hotel.getStars());
		updatedHotel.setCountry(hotel.getCountry());
		updatedHotel.setCity(hotel.getCity());
		updatedHotel.setStreet(hotel.getStreet());
		updatedHotel.setStreet_number(hotel.getStreet_number());
		hotelRepo.save(updatedHotel);
		return "Updated...";
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteHotel(@PathVariable long id) {
		Hotel deletedHotel = hotelRepo.findById(id).get();
		hotelRepo.delete(deletedHotel);
		return "Deleted...";
	}
	
}
