package com.greyes.app.hotel_rest_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyes.app.hotel_rest_api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
	
	Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}
