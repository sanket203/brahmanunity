package com.brahmanunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.AddressDetailsModel;

public interface AddressDetailsRepository extends JpaRepository<AddressDetailsModel, Integer> {

	 @Query("SELECT p FROM AddressDetails p WHERE p.candidateId= :candidateId")
	 public List<AddressDetailsModel> getAlladdressDetails(@Param("candidateId") int candidateId);
}
