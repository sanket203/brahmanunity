package com.brahmanunity.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.PersonalDetailsModel;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.repository.BasicDetailsRepository;
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
			  if(personalDetails.getId() != 0) {
				  BasicDetailsModel findById = new BasicDetailsModel();
				  findById.setName(modifiedData.getFirstName()+" "+modifiedData.getLastName());
				  findById.setBirthDate(modifiedData.getBirthDate());
				  findById.setGender(modifiedData.getGender());
				  findById.setCandidateId(modifiedData.getId());
				  findById.setLastLogin(new Date());
				  findById.setAddressCount(55);
				  basicDetailsRepository.save(findById);
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
	public ResponseBuilder updateRecord(PersonalDetailsDTO personalDetailsModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBuilder deleteRecord(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
