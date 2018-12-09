package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.AbroadDetailsModel;
import com.brahmanunity.repository.AbroadDetailsRepository;
import com.brahmanunity.service.AbroadDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class AbroadDetailsServceImpl implements AbroadDetailsService {
	
	@Autowired
	AbroadDetailsRepository abroadDetailRepository;

	@Override
	public ResponseBuilder saveAbroadDetails(AbroadDetailsModel abroadDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  AbroadDetailsModel modifiedData = abroadDetailRepository.save(abroadDetails);
			  if(modifiedData.getId() != 0) {
				 response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
				 response.setStatus(ResponseMessageConstants.STATUS_200);
			  }
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getAbroadDetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  AbroadDetailsModel abroadDetails = abroadDetailRepository.getAbroadDetails(candidateId);
			  if(abroadDetails == null) {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
			  } else {
				  response.setObject(abroadDetails);
			  }
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}
	
	

}
