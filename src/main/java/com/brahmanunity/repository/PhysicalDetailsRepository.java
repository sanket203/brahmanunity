package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.PhysicalDetailsModel;

public interface PhysicalDetailsRepository extends JpaRepository<PhysicalDetailsModel, Integer>{
	
	@Query("Select p from PhysicalDetails p where p.candidateId= :candidateId")
	public PhysicalDetailsModel getCandidatePhysicalDetails(@Param("candidateId") int candidateId);

}
