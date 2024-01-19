package com.greyes.app.comparator_rest_api.Controllers;

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

import com.greyes.app.comparator_rest_api.Models.Agency;
import com.greyes.app.comparator_rest_api.Repositories.AgencyRepository;

@RequestMapping(value = "agencies")
@RestController
public class AgencyController {
	
	@Autowired
	private AgencyRepository agencyRepo;
	
	@GetMapping(value = "/")
	public List<Agency> getAgencies(){
		return agencyRepo.findAll();
	}
	
	@PostMapping(value = "/")
	public String saveHotel(@RequestBody Agency agency) {
		agencyRepo.save(agency);
		return "Saved...";
	}
	
	@PutMapping(value = "/{id}")
	public String updateHotel(@PathVariable long id, @RequestBody Agency agency) {
		Agency updatedAgency = agencyRepo.findById(id).get();
		updatedAgency.setName(agency.getName());
		updatedAgency.setDisponibility_endpoint(agency.getDisponibility_endpoint());
		agencyRepo.save(updatedAgency);
		return "Updated...";
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteAgency(@PathVariable long id) {
		Agency deletedAgency = agencyRepo.findById(id).get();
		agencyRepo.delete(deletedAgency);
		return "Deleted...";
	}
	
}
