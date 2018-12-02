package com.brahmanunity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.BasicDetailsModel;

public interface BasicDetailsRepository extends JpaRepository<BasicDetailsModel, Integer> {
	
	@Query("SELECT p FROM BasicDetails p WHERE p.gender = :gender")
    public List<BasicDetailsModel> getLatestProfiles(@Param("gender") String gender, Pageable paging);

}
