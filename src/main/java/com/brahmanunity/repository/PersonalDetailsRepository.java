package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brahmanunity.model.PersonalDetailsModel;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetailsModel, Integer>{

}
