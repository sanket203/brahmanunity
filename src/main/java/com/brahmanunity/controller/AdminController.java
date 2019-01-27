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
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.service.AdminService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping(UrlConstants.GET_USER_TO_ACTIVE)
	public ResponseEntity<ResponseBuilder> getUserToActivate(@PathVariable("contact") String contact) {
		ResponseBuilder resp = adminService.getUserToActivate(contact);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
	
	@PostMapping(UrlConstants.ACTIVATE_USER)
	public ResponseEntity<ResponseBuilder> activateUser(@RequestBody BasicDetailsModel basicDetailsModel) {
		ResponseBuilder resp = adminService.activateUser(basicDetailsModel);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
}
