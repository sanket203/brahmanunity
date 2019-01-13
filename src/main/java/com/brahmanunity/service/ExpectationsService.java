package com.brahmanunity.service;

import com.brahmanunity.model.Expectations;
import com.brahmanunity.utils.ResponseBuilder;

public interface ExpectationsService {
	
	public ResponseBuilder saveExpectations(Expectations expectations);
	
	public ResponseBuilder getExpectations(int candidateId);                                                                                                          
	
	

}
