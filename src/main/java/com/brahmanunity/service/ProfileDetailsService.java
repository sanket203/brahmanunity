package com.brahmanunity.service;

import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.utils.ResponseBuilder;

public interface ProfileDetailsService {

	public ResponseBuilder getLatestProfile(String gender, String pageId);
}
