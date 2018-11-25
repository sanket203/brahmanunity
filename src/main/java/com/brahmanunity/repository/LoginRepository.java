package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brahmanunity.model.LoginDetailsModel;

public interface LoginRepository extends JpaRepository<LoginDetailsModel, Integer> {
}
