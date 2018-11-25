package com.brahmanunity.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.LoginRepository;
import com.brahmanunity.service.ProfileDetailsService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;


@Service
public class ProfileDetailsServiceImpl implements ProfileDetailsService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;
   
	@Override
	public ResponseBuilder validateUser(LoginDetailsDto loginPojo) {
		com.brahmanunity.model.LoginDetailsModel loginDetailsModel = ObjectConvertor.convertLoginDetails(loginPojo);
		ResponseBuilder response =  new ResponseBuilder();
		
		String gender = "male";
		try {
			boolean exist = loginRepository.exists(Example.of(loginDetailsModel));
			if(exist) {
				Optional<BasicDetailsModel> userBasicDetail = basicDetailsRepository.findById(loginDetailsModel.getId());
				BasicDetailsModel basicDetailsModel = userBasicDetail.get();
				if(!basicDetailsModel.equals(null)) {
					/*if(basicDetails.getGender().equals("male")) {
						gender = "female";
					}
					List<com.bramhanunity.bramhanunityorg.modal.BasicDetails> latestLoginProfiles = profileDetailsDao.getLatestLoginProfiles(1, gender);*/
					response.setStatus(ResponseMessageConstants.STATUS_200);
					response.setObject(basicDetailsModel);
				} else {
					response.setMessage(ResponseMessageConstants.CHECK_USER_NAME_PASSWORD);
					response.setStatus(ResponseMessageConstants.STATUS_500);
				}
			} 
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		
		return response;
	}

}
