package com.brahmanunity.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.LoginRepository;
import com.brahmanunity.service.UserService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;
	
	@Override
	public ResponseBuilder changePassword(String emailId, String password) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  MatrimonyLogin user = loginRepository.getUser(emailId);
			  user.setPassword(password);
			  loginRepository.save(user);
			  response.setMessage(ResponseMessageConstants.PASSWORD_CHANGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder logoutUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseBuilder validateUser(LoginDetailsDto loginPojo) {
		MatrimonyLogin loginDetailsModel = ObjectConvertor.convertLoginDetails(loginPojo);
		ResponseBuilder response = new ResponseBuilder();
		try {
			MatrimonyLogin user = loginRepository.validateUser(loginDetailsModel.getUser_name(),
					loginDetailsModel.getPassword());
			if (user != null) {
				BasicDetailsModel userBasicDetail = basicDetailsRepository.getCandidateDetails(user.getId());
				if (userBasicDetail != null) {
					response.setStatus(ResponseMessageConstants.STATUS_200);
					response.setObject(userBasicDetail);
					userBasicDetail.setLastLogin(new Date());
					basicDetailsRepository.saveAndFlush(userBasicDetail);
				} else {
					response.setMessage(ResponseMessageConstants.CHECK_USER_NAME_PASSWORD);
					response.setStatus(ResponseMessageConstants.STATUS_500);
				}
			}
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}

		return response;
	}

	@Override
	public ResponseBuilder checkUser(long contact) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  MatrimonyLogin user = loginRepository.getUser(String.valueOf(contact));
			  if(user != null) {
				  BasicDetailsModel candidateDetails = basicDetailsRepository.getCandidateDetails(user.getId());
				  response.setObject(candidateDetails);
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
