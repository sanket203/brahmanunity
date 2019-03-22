package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.FamilyDetailsModel;
import com.brahmanunity.repository.FamilyDetailsRepository;
import com.brahmanunity.service.FamilyDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class FamilyDetailsServiceImpl implements FamilyDetailsService{
	
	@Autowired
	FamilyDetailsRepository familyRepository;

	@Override
	public ResponseBuilder saveFamilyDetails(FamilyDetailsModel familyDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  familyRepository.save(familyDetails);
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getFamilyDetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  FamilyDetailsModel familyDetails = familyRepository.getFamilyDetails(candidateId);
			  if(familyDetails != null) {
				  response.setObject(familyDetails);
				  response.setStatus(ResponseMessageConstants.STATUS_200);
			  } else {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
				  response.setStatus(ResponseMessageConstants.STATUS_500);
			  }
			
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

}
