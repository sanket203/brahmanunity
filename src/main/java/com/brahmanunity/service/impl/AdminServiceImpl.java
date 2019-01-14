package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.LoginRepository;
import com.brahmanunity.service.AdminService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	BasicDetailsRepository basicRepository;

	@Override
	public ResponseBuilder getUserToActivate(String contact) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			 MatrimonyLogin user = loginRepository.getUser(contact);
			 BasicDetailsModel candidateDetails = basicRepository.getCandidateDetails(user.getId());
			 response.setObject(candidateDetails);
			 response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}
	
	@Override
	public ResponseBuilder activateUser(BasicDetailsModel basicDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  basicDetails.setAddressCount(50);
			  basicRepository.save(basicDetails);
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
			  
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder deleteUser(String contact) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
