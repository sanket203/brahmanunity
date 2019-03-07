package com.brahmanunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.service.ProfileDetailsService;
import com.brahmanunity.service.UserService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class LoginController {
	
	@Autowired
	ProfileDetailsService profileDetailsServices;
	
	@Autowired
	UserService userService;
	
	@PostMapping(UrlConstants.LOGIN_URL)
	public ResponseEntity<ResponseBuilder> authenticateUser(@RequestBody LoginDetailsDto loginDetailsDto) {
		ResponseBuilder respBuild = userService.validateUser(loginDetailsDto);
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
	
	@PostMapping(UrlConstants.LOGOUT)
	public @ResponseBody ResponseEntity<ResponseBuilder> logoutUser() {
		return null;
	}
	
	@PostMapping(UrlConstants.CHANGE_PASSWORD)
	public @ResponseBody ResponseEntity<ResponseBuilder> changePassword(@RequestBody LoginDetailsDto loginDetails) {
		String user_name = loginDetails.getUser_name();
		String password = loginDetails.getPassword();
		ResponseBuilder resp = userService.changePassword(user_name, password);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
	
	@PostMapping(UrlConstants.CHECK_USER)
	public ResponseEntity<ResponseBuilder> checkUserRegistration(@RequestBody PersonalDetailsDTO personalDetailsDto) {
		ResponseBuilder resp = userService.checkUser(personalDetailsDto);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@PostMapping(UrlConstants.REGISTER_USER)
	public ResponseEntity<ResponseBuilder> registerUser(@PathVariable("candidateId") String candidateId,
			                                            @PathVariable("isRegistered") boolean isRegistered) {
		long candidate = Long.parseLong(candidateId);
		ResponseBuilder response = userService.registration(isRegistered, candidate);
		ResponseEntity<ResponseBuilder> resp = new ResponseEntity<ResponseBuilder>(response,HttpStatus.OK);
		return resp;
	}
	
}
