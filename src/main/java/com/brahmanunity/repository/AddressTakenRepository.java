package com.brahmanunity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brahmanunity.model.AddressTakenModel;

public interface AddressTakenRepository extends JpaRepository<AddressTakenModel, Integer>{
	
	@Query("SELECT p.profileId FROM AddressTaken p WHERE p.userId = :userId")
	public List<Integer> getMyAddressProfiles(@Param("userId") int userId, Pageable paging);
	
	@Query("SELECT p FROM AddressTaken p WHERE p.userId= :userId AND p.profileId= :profileId")
	public AddressTakenModel checkAddress(@Param("userId") int userId, @Param("profileId") int profileId);

}
