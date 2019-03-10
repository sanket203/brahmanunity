
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
import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.service.AddressDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class AddressController {
	
	@Autowired
	AddressDetailsService addressDetailsService;
	
	@PostMapping(UrlConstants.SAVE_ADDRESS_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> saveUserAddress(@RequestBody AddressDetailsModel addressDetails) {
		ResponseBuilder resp = addressDetailsService.saveAddressDetails(addressDetails);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_ADDRESS_DETAILS)
	public @ResponseBody ResponseEntity<ResponseBuilder> getAddressDetails(@PathVariable("candidateId") String candidateId) {
		ResponseBuilder resp = addressDetailsService.getAddressdetails(Integer.parseInt(candidateId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.ADDRESS_TAKEN_PROFILE)
	public @ResponseBody ResponseEntity<ResponseBuilder> getAddressTakenProfiles(@PathVariable("userId") String userId,
			                                                                     @PathVariable("pageId") String pageId) {
		
		ResponseBuilder resp = addressDetailsService.getAddressTakenProfiles(Integer.parseInt(userId), Integer.parseInt(pageId));
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(UrlConstants.GET_PROFILE_ADDRESS)
	public ResponseEntity<ResponseBuilder> getProfileAddress(@PathVariable("candidateId") int candidateId,     
			                                                 @PathVariable("profileId") int profileId,
			                                                 @PathVariable("isAddressTaken") boolean isAddressTaken) {
		ResponseBuilder resp = addressDetailsService.getProfileAddress(candidateId, profileId, isAddressTaken);
		ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
		return response;
	}

}
