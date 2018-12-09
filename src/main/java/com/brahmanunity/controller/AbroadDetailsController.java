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
import com.brahmanunity.model.AbroadDetailsModel;
import com.brahmanunity.service.AbroadDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class AbroadDetailsController {
	
	@Autowired
	AbroadDetailsService abroadService;
	
	@PostMapping(UrlConstants.SAVE_ABROAD_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> saveAbroadDetails(@RequestBody AbroadDetailsModel abroadDetails) {
		ResponseBuilder resp = abroadService.saveAbroadDetails(abroadDetails);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_ABROAD_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getAbroadDetails(@PathVariable("candidateId") String candidateId) {
		ResponseBuilder resp = abroadService.getAbroadDetails(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}

}
