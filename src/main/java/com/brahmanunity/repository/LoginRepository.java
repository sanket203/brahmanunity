package com.brahmanunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.MatrimonyLogin;

public interface LoginRepository extends JpaRepository<MatrimonyLogin, Integer> {
	
	@Query("SELECT p FROM MatrimonyLogin p WHERE p.user_name = :user_name AND p.password = :password")
    public MatrimonyLogin validateUser(@Param("user_name") String user_name, @Param("password") String password);
	
	@Query("SELECT p FROM MatrimonyLogin p WHERE p.user_name = :user_name")
	public MatrimonyLogin getUser(@Param("user_name") String user_name);
	
}
