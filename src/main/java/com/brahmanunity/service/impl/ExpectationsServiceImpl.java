package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.Expectations;
import com.brahmanunity.repository.ExpectationRepository;
import com.brahmanunity.service.ExpectationsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class ExpectationsServiceImpl implements ExpectationsService {
	
	@Autowired
	ExpectationRepository expectationRepository;
	
	@Override
	public ResponseBuilder saveExpectations(Expectations expectations) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  expectationRepository.save(expectations);
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getExpectations(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  Expectations expectations = expectationRepository.retrieveExpectations(candidateId);
			  if(expectations != null) {
				  response.setObject(expectations);
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
