package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.FamilyDetailsModel;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetailsModel, Integer>{
	
	@Query("SELECT p FROM FamilyDetails p WHERE p.candidateId= :candidateId")
	public FamilyDetailsModel getFamilyDetails(@Param("candidateId") int candidateId);

}
