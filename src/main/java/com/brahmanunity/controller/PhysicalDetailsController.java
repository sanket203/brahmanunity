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
import com.brahmanunity.model.PhysicalDetailsModel;
import com.brahmanunity.service.PhysicalDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class PhysicalDetailsController {
	
	@Autowired
	PhysicalDetailsService physicalDetilsService;
	
	@PostMapping(UrlConstants.ADD_PHYSICAL_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> savePersonalDetails(@RequestBody PhysicalDetailsModel physicalDetails) {
		ResponseEntity<ResponseBuilder> response = null;
		ResponseBuilder respBuilder = physicalDetilsService.saveRecord(physicalDetails);
		response = new ResponseEntity<ResponseBuilder>(respBuilder,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_PHYSICAL_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getRecord(@PathVariable("candidateId") String id) {
		ResponseBuilder respBuild = physicalDetilsService.getRecord(Integer.parseInt(id));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;
	}
	
	/*@DeleteMapping(UrlConstants.DELETE_PRSONAL_DETAILS_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> deleteUser(@PathVariable("id") String id) {
		ResponseBuilder respBuild = physicalDetilsService.deleteRecord(Integer.parseInt(id));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(respBuild,HttpStatus.OK);
		return response;
	}*/

}
