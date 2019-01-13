package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.HoroscopeDetailsModel;

public interface HoroscopeDetailsRepository extends JpaRepository<HoroscopeDetailsModel, Integer>{

	@Query("SELECT p FROM HoroscopeDetails p WHERE p.candidateId = :candidateId")
	public HoroscopeDetailsModel getHoroscopeDetails(@Param("candidateId") int candidateId);
	
}
