package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.QualificationModel;

public interface QualificationRepository extends JpaRepository<QualificationModel, Integer>{
	
	@Query("Select p from Qualification p where p.candidateId= :candidateId")
	public QualificationModel getCandidateQualificationDetails(@Param("candidateId") int candidateId);

}

