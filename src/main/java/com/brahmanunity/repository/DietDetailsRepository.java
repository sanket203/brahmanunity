package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.DietDetailsModel;

public interface DietDetailsRepository extends JpaRepository<DietDetailsModel, Integer>{
	
	@Query("SELECT p FROM DietDetails p WHERE p.candidateId= :candidateId")
	public DietDetailsModel getDietDetails(@Param("candidateId") int candidateId);

}
