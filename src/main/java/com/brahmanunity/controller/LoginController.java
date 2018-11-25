package com.brahmanunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ResponseBuilder> getLatestProfiles(@RequestBody LoginDetailsDto loginDetailsDto) {
		ResponseBuilder respBuild = profileDetailsServices.validateUser(loginDetailsDto);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;		
	}
}
