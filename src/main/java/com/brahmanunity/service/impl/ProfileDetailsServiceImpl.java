package com.brahmanunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.pojo.BasicDetailsDto;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.service.ProfileDetailsService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class ProfileDetailsServiceImpl implements ProfileDetailsService {

	@Autowired
	BasicDetailsRepository basicDetailsRepository;


	@Override
	public ResponseBuilder getLatestProfile(String gender, String pageId) {
		int page = Integer.parseInt(pageId);
		ResponseBuilder response = new ResponseBuilder();
		String genderToPass = "male";
		try {
			PageRequest pageRequest = PageRequest.of(page, 5, Direction.DESC, "lastLogin");
			Pageable pageable = pageRequest;
			if(gender.equals(genderToPass)) {
				genderToPass = "female";
			}
			List<BasicDetailsModel> latestProfiles = basicDetailsRepository.getLatestProfiles(genderToPass, pageable);
			if(latestProfiles.size() > 0) {
				List<BasicDetailsDto> profiles = new ArrayList();
				for (BasicDetailsModel basicDetail : latestProfiles) {
					profiles.add(ObjectConvertor.convertBasicdetailsToBasicDTO(basicDetail));
				}
				response.setStatus(ResponseMessageConstants.STATUS_200);
				response.setObject(profiles);
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
