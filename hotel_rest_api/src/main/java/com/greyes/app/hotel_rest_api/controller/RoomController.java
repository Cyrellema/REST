package com.greyes.app.hotel_rest_api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyes.app.hotel_rest_api.model.Agency;
import com.greyes.app.hotel_rest_api.model.Room;
import com.greyes.app.hotel_rest_api.repository.AgencyRepository;
import com.greyes.app.hotel_rest_api.repository.RoomRepository;
import com.greyes.app.hotel_rest_api.requests.SearchRequest;


@RestController
@RequestMapping("search")
public class RoomController {
	
	@Autowired
	public RoomRepository roomRepo;
	
	@Autowired
	public AgencyRepository agencyRepo;
	
	//private static final String uri = "Trivago/api";

	@PostMapping("/")
	public List<Room> TypeRoom(@RequestBody SearchRequest search) {
		List<Room> offer = new ArrayList<Room>();
		Optional<Agency> agency = agencyRepo.findByLoginAndPassword(search.getAgency_login(), search.getAgency_password());
		if (agency.isEmpty()) return null;
		for (Room room : roomRepo.findByBeds(search.getBedsWanted())) {
			room.setPrice(room.getPrice() * ( 1-agency.get().getReduction() ));
			if (room.getPrice() > search.getMaxPrice() || room.getPrice() < search.getMinPrice()) continue;
			offer.add(room);
		}
		return offer;
	}
	
	@GetMapping("/pic")

	  @RequestMapping(value = "/sid", method = RequestMethod.GET,
	            produces = MediaType.IMAGE_JPEG_VALUE)
	    public ResponseEntity<InputStreamResource> getImage() throws IOException {

	        var imgFile = new ClassPathResource("image/sid.jpg");

	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(new InputStreamResource(imgFile.getInputStream()));
	    }
	
	//si doit aller chercher une variable --> /{..} et dans () -> @pathVariable ..
	
	//avec PostMapping -> identifiant créer par défaut et pas besoin de spécifier id dans chemin
	


}

