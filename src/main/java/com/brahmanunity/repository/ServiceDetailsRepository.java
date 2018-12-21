package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.ServiceDetailsModel;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetailsModel, Integer> {
	
	@Query("SELECT p FROM ServiceDetails p WHERE p.candidateId= :candidateId")
	public ServiceDetailsModel getServiceDetails(@Param("candidateId") int candidateId);

}
