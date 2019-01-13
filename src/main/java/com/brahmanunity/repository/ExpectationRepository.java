package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.Expectations;

public interface ExpectationRepository extends JpaRepository<Expectations, Integer> {
	
	@Query("SELECT p FROM Expectations p WHERE p.candidateId= :candidateId")
	public Expectations retrieveExpectations(@Param("candidateId") int candidateId);

}
