package com.brahmanunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.model.QualificationModel;
import com.brahmanunity.service.QualificationDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class QualificationController {
	
	@Autowired
	QualificationDetailsService qualificationService;
	
	@RequestMapping(UrlConstants.SAVE_QUALIFICATION)
	public @ResponseBody ResponseEntity<ResponseBuilder> saveQualificationDetails(@RequestBody QualificationModel qualificationModel) {
		ResponseBuilder resp = qualificationService.addQualificationDetails(qualificationModel);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}

	@RequestMapping(UrlConstants.GET_QUALIFICATION)
	public @ResponseBody ResponseEntity<ResponseBuilder> getQualificationDetails(@PathVariable("candidateId") String candidateId) {
		int userId = Integer.parseInt(candidateId);
		ResponseBuilder resp = qualificationService.getQualificationDetails(userId);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	

}
