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
import com.brahmanunity.model.FamilyDetailsModel;
import com.brahmanunity.service.FamilyDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class FamilyDetailsController {
	
	@Autowired
	FamilyDetailsService familyDetailsServices;
	
	@PostMapping(UrlConstants.SAVE_FAMILY_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> saveFamilyDetails(@RequestBody FamilyDetailsModel familyDetails) {
		ResponseBuilder resp = familyDetailsServices.saveFamilyDetails(familyDetails);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_FAMILY_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getFamilyDetails(@PathVariable("candidateId") String candidateId) {
		ResponseBuilder resp = familyDetailsServices.getFamilyDetails(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<>(resp, HttpStatus.OK);
		return response;
	}
	

}
