package com.brahmanunity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
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
		MatrimonyLogin loginDetailsModel = ObjectConvertor.convertLoginDetails(loginPojo);
		ResponseBuilder response = new ResponseBuilder();
		try {
			MatrimonyLogin user = loginRepository.validateUser(loginDetailsModel.getUser_name(),
					loginDetailsModel.getPassword());
			if (user != null) {
				Optional<BasicDetailsModel> userBasicDetail = basicDetailsRepository.findById(user.getId());
				BasicDetailsModel basicDetailsModel = userBasicDetail.get();
				if (basicDetailsModel != null) {
					response.setStatus(ResponseMessageConstants.STATUS_200);
					response.setObject(basicDetailsModel);
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
	public ResponseBuilder getLatestProfile(String gender, String pageId) {
		int page = Integer.parseInt(pageId);
		ResponseBuilder response = new ResponseBuilder();
		String genderToPass = "male";
		try {
			PageRequest pageRequest = PageRequest.of(page, 10, Direction.DESC, "lastLogin");
			Pageable pageable = pageRequest;
			if(gender.equals(genderToPass)) {
				genderToPass = "female";
			}
			List<BasicDetailsModel> latestProfiles = basicDetailsRepository.getLatestProfiles(genderToPass, pageable);
			if(latestProfiles.size() > 0) {
				response.setStatus(ResponseMessageConstants.STATUS_200);
				response.setObject(latestProfiles);
			} else {
				response.setMessage(ResponseMessageConstants.CHECK_USER_NAME_PASSWORD);
				response.setStatus(ResponseMessageConstants.STATUS_500);
			}
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		
		return response;
	}

}
