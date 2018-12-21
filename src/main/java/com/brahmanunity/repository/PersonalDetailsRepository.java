package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.PersonalDetailsModel;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetailsModel, Integer>{
	
	@Query("SELECT p.id FROM PersonalDetails p WHERE p.mailId= :mailid")
	public int getUserId(@Param("mailid") String mailid);

}
