package com.brahmanunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.service.PersonalDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class PersonalController {
	
	@Autowired
	PersonalDetailsService personalDetailsService;
	
	@PostMapping(UrlConstants.ADD_PERSONAL_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> savePersonalDetails(@RequestBody PersonalDetailsDTO personalDetails) {
		ResponseEntity<ResponseBuilder> response = null;
		ResponseBuilder respBuilder = personalDetailsService.saveRecord(personalDetails);
		response = new ResponseEntity<ResponseBuilder>(respBuilder,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_PERSONAL_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getRecord(@PathVariable("candidateId") String id) {
		ResponseBuilder respBuild = personalDetailsService.getRecord(Integer.parseInt(id));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping(UrlConstants.DELETE_PRSONAL_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> deleteUser(@PathVariable("id") String id) {
		ResponseBuilder respBuild = personalDetailsService.deleteRecord(Integer.parseInt(id));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;
	}
	
	

}
