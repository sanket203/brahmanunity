package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.AbroadDetailsModel;

public interface AbroadDetailsRepository extends JpaRepository<AbroadDetailsModel, Integer>{
	
	@Query("SELECT p FROM AbroadDetails p WHERE p.candidateId= :candidateId")
	public AbroadDetailsModel getAbroadDetails(@Param("candidateId") int candidateId);

}
