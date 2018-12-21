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
import com.brahmanunity.model.ServiceDetailsModel;
import com.brahmanunity.service.JobDetailsService;
import com.brahmanunity.utils.ResponseBuilder;


@RestController
public class JobDetailsController {
	
	@Autowired
	JobDetailsService jobService;
	
	@PostMapping(UrlConstants.SAVE_SERVICE_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> addJobDetails(@RequestBody ServiceDetailsModel serviceDetails) {
		ResponseBuilder resp = jobService.saveServiceDetails(serviceDetails);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_SERVICE_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getJobDetails(@PathVariable("candidateId") String candidateId) {
		ResponseBuilder resp = jobService.getServiceDetails(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	

}
