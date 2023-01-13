package com.example.travelapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	List<Travel> findById(@Param("id") String id);
	
	@Transactional
    void deleteById(@Param("id") String id);
}
