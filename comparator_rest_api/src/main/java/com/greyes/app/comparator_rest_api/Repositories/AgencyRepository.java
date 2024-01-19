package com.greyes.app.comparator_rest_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyes.app.comparator_rest_api.Models.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

}
