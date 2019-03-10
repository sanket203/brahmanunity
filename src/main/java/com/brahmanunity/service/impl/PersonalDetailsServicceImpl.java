package com.brahmanunity.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
import com.brahmanunity.model.PersonalDetailsModel;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.repository.AddressDetailsRepository;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.LoginRepository;
import com.brahmanunity.repository.PersonalDetailsRepository;
import com.brahmanunity.service.PersonalDetailsService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;

@Service()
public class PersonalDetailsServicceImpl implements PersonalDetailsService {
	
	@Autowired
	PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	AddressDetailsRepository addressRepository;

	@Override
	public ResponseBuilder getRecord(int id) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			 Optional<PersonalDetailsModel> findById = personalDetailsRepository.findById(id);
			 PersonalDetailsModel personalDetailsModel = findById.get();
			 if(personalDetailsModel == null) {
				 response.setMessage(ResponseMessageConstants.NO_DATA_FOUND);
				 response.setStatus(ResponseMessageConstants.STATUS_500);
			 } else {
				 PersonalDetailsDTO personalDetails = ObjectConvertor.convertPersonalDetailsDTO(personalDetailsModel);
				 response.setObject(personalDetails);
				 response.setStatus(ResponseMessageConstants.STATUS_200);
			 }
		} catch (Exception e) {
			 response.setMessage(e.getMessage());
			 response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder saveRecord(PersonalDetailsDTO personalDetailsDto) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  PersonalDetailsModel personalDetails = ObjectConvertor.convertPersonalDetails(personalDetailsDto);
			  PersonalDetailsModel modifiedData = personalDetailsRepository.save(personalDetails);
			  
			  BasicDetailsModel findById = basicDetailsRepository.getCandidateDetails(modifiedData.getId());
			  if(findById == null) {
				  findById = new BasicDetailsModel();
			  }
			  findById.setName(modifiedData.getFirstName()+" "+modifiedData.getLastName());
			  findById.setBirthDate(modifiedData.getBirthDate());
			  findById.setGender(modifiedData.getGender());
			  findById.setCandidateId(modifiedData.getId());
			  findById.setLastLogin(new Date());
			  basicDetailsRepository.save(findById);
			  
			  List<AddressDetailsModel> addresses = addressRepository.getAlladdressDetails(modifiedData.getId());
			  if(addresses.size()==0) {
				  AddressDetailsModel address = new AddressDetailsModel();
				  address.setAddress(personalDetailsDto.getAddress());
				  address.setContact(personalDetailsDto.getContact());
				  address.setEmailId(personalDetailsDto.getMailId());
				  address.setCandidateId(modifiedData.getId());
				  if(personalDetailsDto.getAlternateNumber() != 0) {
					  address.setAlternateNumber(personalDetailsDto.getAlternateNumber());
				  }
				  addressRepository.save(address);
			  }
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setObject(modifiedData);
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

	@Override
	public ResponseBuilder register(PersonalDetailsDTO personalDetailsDto) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  PersonalDetailsModel personalDetails = ObjectConvertor.convertPersonalDetails(personalDetailsDto);
			  PersonalDetailsModel personalModel = personalDetailsRepository.save(personalDetails);
			  
			  MatrimonyLogin mLogin = new MatrimonyLogin();
			  mLogin.setUser_name(String.valueOf(personalDetailsDto.getContact()));
			  mLogin.setPassword(personalDetailsDto.getPassword());
			  loginRepository.save(mLogin);
			  
			  BasicDetailsModel basicDetails = new BasicDetailsModel();
			  basicDetails.setName(personalDetailsDto.getFirstName()+" "+personalDetailsDto.getLastName());
			  basicDetails.setRegistered("Not Registered");
			  basicDetails.setCandidateId(personalModel.getId());
			  BasicDetailsModel basicDetailsModel = basicDetailsRepository.save(basicDetails);
			  
			  AddressDetailsModel address = new AddressDetailsModel();
			  address.setCandidateId(personalModel.getId());
			  address.setContact(personalDetailsDto.getContact());
			  addressRepository.save(address);
			  
			  response.setObject(basicDetailsModel);
			  response.setMessage(ResponseMessageConstants.REGISTRATION_SUCCESS);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
			  
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		} 
		return response;
	}


}
