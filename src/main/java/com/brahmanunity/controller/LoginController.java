package com.brahmanunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.service.ProfileDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class LoginController {
	
	@Autowired
	ProfileDetailsService profileDetailsServices;
	
	@PostMapping(UrlConstants.LOGIN_URL)
	public ResponseEntity<ResponseBuilder> authenticateUser(@RequestBody LoginDetailsDto loginDetailsDto) {
		ResponseBuilder respBuild = profileDetailsServices.validateUser(loginDetailsDto);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;		
	}
	
	@GetMapping(UrlConstants.GET_LATEST_PROFILES)
	public ResponseEntity<ResponseBuilder> getLatestProfiles(@PathVariable("gender") String gender, 
			                                                 @PathVariable("pageId") String pageId){
		ResponseBuilder respBuild = profileDetailsServices.getLatestProfile(gender, pageId);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;
	}
	
}
