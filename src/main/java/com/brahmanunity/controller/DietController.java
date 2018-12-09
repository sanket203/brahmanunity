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
import com.brahmanunity.model.DietDetailsModel;
import com.brahmanunity.service.DietDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class DietController {
	
	@Autowired
	DietDetailsService dietService;
	
	@PostMapping(UrlConstants.SAVE_DIET_DETAILS)
	
	public @ResponseBody ResponseEntity<ResponseBuilder>saveeDietDetails(@RequestBody DietDetailsModel dietDetails) {
		ResponseBuilder resp = dietService.saveDietDetails(dietDetails);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_DIET_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getDietDetails(@PathVariable("candidateId") String candidateId) {
		ResponseBuilder resp = dietService.getDietDetails(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}

}
