package com.brahmanunity.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
import com.brahmanunity.model.PersonalDetailsModel;
import com.brahmanunity.pojo.BasicDetailsDto;
import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.repository.AddressDetailsRepository;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.LoginRepository;
import com.brahmanunity.repository.PersonalDetailsRepository;
import com.brahmanunity.service.PersonalDetailsService;
import com.brahmanunity.service.UserService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;
	
	@Autowired
	PersonalDetailsService personalService;
	
	@Autowired
	PersonalDetailsRepository personalRepository;
	
	@Autowired
	AddressDetailsRepository addressRepository;
	
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
					BasicDetailsDto basicDetails = ObjectConvertor.convertBasicdetailsToBasicDTO(userBasicDetail);
					response.setStatus(ResponseMessageConstants.STATUS_200);
					response.setObject(basicDetails);
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
	public ResponseBuilder checkUser(PersonalDetailsDTO personalDetailsDto) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  MatrimonyLogin user = loginRepository.getUser(String.valueOf(personalDetailsDto.getContact()));
			  if(user != null) {
				  user.setPassword(personalDetailsDto.getPassword());
				  loginRepository.save(user);
				  
				  PersonalDetailsModel personalDetails = ObjectConvertor.convertPersonalDetails(personalDetailsDto);
				  personalRepository.save(personalDetails);
				  
				  BasicDetailsModel candidateDetails = basicDetailsRepository.getCandidateDetails(user.getId());
				  candidateDetails.setName(personalDetailsDto.getFirstName()+" "+personalDetailsDto.getLastName());
				  candidateDetails.setLastLogin(new Date());
				  candidateDetails.setRegistered("non registered");
				  basicDetailsRepository.save(candidateDetails);
				  
				  List<AddressDetailsModel> addresses = addressRepository.getAlladdressDetails(user.getId());
				  if(addresses.size()>0) {
					  AddressDetailsModel address = addresses.get(0);
					  address.setContact(personalDetailsDto.getContact());
					  addressRepository.save(address);
				  }
				  response.setObject(candidateDetails);
				  response.setStatus(ResponseMessageConstants.STATUS_200);
			  } else {
				  response = personalService.register(personalDetailsDto);
			  }
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder registration(String isRegistered, long candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  BasicDetailsModel basicDetails = basicDetailsRepository.getCandidateDetails((int)candidateId);
			  if(basicDetails != null) {
				  basicDetails.setRegistered(isRegistered);
				  basicDetailsRepository.save(basicDetails);
				  response.setObject(basicDetails);
				  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
				  response.setStatus(ResponseMessageConstants.STATUS_200);
			  }
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		
		return response;
	}
}
