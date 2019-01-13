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
import com.brahmanunity.model.HoroscopeDetailsModel;
import com.brahmanunity.service.HoroscopeService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class HoroscopeController {

	@Autowired
	HoroscopeService horoscopeService;
	
	@PostMapping(UrlConstants.SAVE_HOROSCOPE_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> addHoroscopeDetails(@RequestBody HoroscopeDetailsModel horoscopeDetails) {
		ResponseBuilder resp = horoscopeService.saveHoroscopeDetails(horoscopeDetails);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_HOROSCOPE_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getHoroscopeDetails(@PathVariable ("candidateId") String candidateId) {
		ResponseBuilder resp = horoscopeService.getHoroscopeDetails(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
}
