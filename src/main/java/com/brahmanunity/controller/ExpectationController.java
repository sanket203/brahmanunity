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
import com.brahmanunity.model.Expectations;
import com.brahmanunity.service.ExpectationsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class ExpectationController {

	@Autowired
	ExpectationsService expectationService;
	
	@PostMapping(UrlConstants.SAVE_EXPECTATION_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> saveExpectationCriteria(@RequestBody Expectations expectations) {
		ResponseBuilder resp = expectationService.saveExpectations(expectations);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_EXPECTATION_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> retrieveExpectation(@PathVariable("candidateId") String candidateId) {
		ResponseBuilder resp = expectationService.getExpectations(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
	
	
	
}
