package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brahmanunity.model.BasicDetailsModel;

public interface BasicDetailsRepository extends JpaRepository<BasicDetailsModel, Integer> {

}
