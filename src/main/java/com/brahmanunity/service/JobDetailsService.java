package com.brahmanunity.service;

import com.brahmanunity.model.ServiceDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface JobDetailsService {

	public ResponseBuilder saveServiceDetails(ServiceDetailsModel serviceDetails);
	
	public ResponseBuilder getServiceDetails(int candidateId);
}
