package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.ServiceDetailsModel;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.ServiceDetailsRepository;
import com.brahmanunity.service.JobDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {
	
	@Autowired
    ServiceDetailsRepository serviceDetailsRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;

	@Override
	public ResponseBuilder saveServiceDetails(ServiceDetailsModel serviceDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  ServiceDetailsModel serviceData = serviceDetailsRepository.save(serviceDetails);
			  if(serviceData != null) {
				  BasicDetailsModel candidateDetails = basicDetailsRepository.getCandidateDetails(serviceData.getCandidateId());
				  if(candidateDetails != null) {
					  if(! serviceDetails.getAnnualIncome().equals(candidateDetails.getIncome())) {
						  candidateDetails.setIncome(serviceDetails.getAnnualIncome());
					  }
					  basicDetailsRepository.save(candidateDetails);
				  }
			  }
			 response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE); 
			 response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getServiceDetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  ServiceDetailsModel serviceDetails = serviceDetailsRepository.getServiceDetails(candidateId);
			  if(serviceDetails != null) {
				  response.setObject(serviceDetails);
			  } else {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
			  }
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

}
