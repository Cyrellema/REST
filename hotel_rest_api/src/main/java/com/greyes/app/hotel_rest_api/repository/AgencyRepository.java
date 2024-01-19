package com.greyes.app.hotel_rest_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyes.app.hotel_rest_api.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
	
	Optional<Agency> findByLoginAndPassword(String login, String password);

}
