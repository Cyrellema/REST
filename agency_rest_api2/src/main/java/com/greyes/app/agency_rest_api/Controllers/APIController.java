package com.greyes.app.agency_rest_api.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.greyes.app.agency_rest_api.Models.Hotel;
import com.greyes.app.agency_rest_api.Repositories.HotelRepository;
import com.greyes.app.agency_rest_api.RequestsAndReponses.FindRequest;
import com.greyes.app.agency_rest_api.RequestsAndReponses.FindResponse;
import com.greyes.app.agency_rest_api.RequestsAndReponses.ReserveRequest;

@RequestMapping(value = "api/v1")
@RestController
public class APIController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private HotelRepository hotelRepo;
	
	@PostMapping(value = "/find")
	public List<FindResponse> find(@RequestBody FindRequest findRequest){
		
		List<FindResponse> result = new ArrayList<FindResponse>();
		
		for (Hotel hotel : hotelRepo.findByCityAndStars(findRequest.getCity(), findRequest.getStars())) {
			
			String url = hotel.getDisponibility_endpoint();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
		    Map<String, Object> map = new HashMap<>();
		    map.put("bedsWanted", findRequest.getBedsWanted());
		    map.put("minPrice", findRequest.getMinPrice());
		    map.put("maxPrice", findRequest.getMaxPrice());
		    map.put("agency_login", env.getProperty("agency.login"));
		    map.put("agency_password", env.getProperty("agency.password"));

		    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
		    
		    Object[] offers = restTemplate.postForObject(url, entity, Object[].class);
		    
		    result.add(new FindResponse(Arrays.asList(offers), hotel));
			
		}
				
		return result;
	}
	
	@PostMapping(value = "/reserve")
	public Object reserve(@RequestBody ReserveRequest reserveRequest) {
		
		Optional<Hotel> o_hotel = hotelRepo.findById(reserveRequest.getHotel_id());
		if (o_hotel.isEmpty()) return null;
		
		Hotel hotel = o_hotel.get();
		
		String url = hotel.getReservation_endpoint();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
	    Map<String, Object> map = new HashMap<>();
	    map.put("room_id", reserveRequest.getRoom_id());
	    map.put("arrival", reserveRequest.getArrival());
	    map.put("departure", reserveRequest.getDeparture());
	    map.put("firstName", reserveRequest.getFirstName());
	    map.put("lastName", reserveRequest.getLastName());
	    map.put("agency_login", env.getProperty("agency.login"));
	    map.put("agency_password", env.getProperty("agency.password"));

	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
	    
	    Object response = restTemplate.postForObject(url, entity, Object[].class);
		
		return response;
	}


}
