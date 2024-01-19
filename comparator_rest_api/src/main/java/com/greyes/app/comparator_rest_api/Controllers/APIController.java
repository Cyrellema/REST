package com.greyes.app.comparator_rest_api.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.greyes.app.comparator_rest_api.Models.Agency;
import com.greyes.app.comparator_rest_api.Repositories.AgencyRepository;
import com.greyes.app.comparator_rest_api.RequestsAndReponses.FindRequest;
import com.greyes.app.comparator_rest_api.RequestsAndReponses.FindResponse;

@RequestMapping(value = "api/v1")
@RestController
public class APIController {
	
	@Autowired
	private AgencyRepository agencyRepo;
	
	@PostMapping(value = "/find")
	public List<FindResponse> find(@RequestBody FindRequest findRequest){
		
		List<FindResponse> result = new ArrayList<FindResponse>();
		
		for (Agency agency : agencyRepo.findAll()) {
			
			String url = agency.getDisponibility_endpoint();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
		    Map<String, Object> map = new HashMap<>();
		    map.put("bedsWanted", findRequest.getBedsWanted());
		    map.put("minPrice", findRequest.getMinPrice());
		    map.put("maxPrice", findRequest.getMaxPrice());
		    map.put("city", findRequest.getCity());
		    map.put("stars", findRequest.getStars());

		    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
		    
		    Object offers = restTemplate.postForObject(url, entity, Object[].class);
		    
		    result.add(new FindResponse(agency, offers));
			
		}
				
		return result;
	}

}
