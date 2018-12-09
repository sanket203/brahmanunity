package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.PhysicalDetailsModel;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.PhysicalDetailsRepository;
import com.brahmanunity.service.PhysicalDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service(value="PhysicalDetailsServiceImpl")
public class PhysicalDetailsServiceImpl implements PhysicalDetailsService {
	
	@Autowired
	PhysicalDetailsRepository physicalRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;

	@Override
	public ResponseBuilder saveRecord(PhysicalDetailsModel physicalDetails) {
		ResponseBuilder response = new ResponseBuilder();
		String message = null;
		try {
			  PhysicalDetailsModel modifiedData = physicalRepository.save(physicalDetails);
			  if(modifiedData != null) {
				  BasicDetailsModel candidateDetails = basicDetailsRepository.getCandidateDetails(modifiedData.getCandidateId());
				  if(candidateDetails != null) {
					  candidateDetails.setHeight(modifiedData.getHeight());
					  basicDetailsRepository.saveAndFlush(candidateDetails);
				  }
			  }
			  message = ResponseMessageConstants.SUCCESS_MESSAGE;
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			message = e.getMessage();
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		response.setMessage(message);
		return response;
	}

	@Override
	public ResponseBuilder getRecord(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  PhysicalDetailsModel candidatePhysicalDetails = physicalRepository.getCandidatePhysicalDetails(candidateId);
			  if(candidatePhysicalDetails != null) {
				  response.setObject(candidatePhysicalDetails);
			  } else {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
			  }
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder deleteRecord(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
