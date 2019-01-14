package com.brahmanunity.service;

import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface AdminService {
	
	public ResponseBuilder getUserToActivate(String contact);

	public ResponseBuilder activateUser(BasicDetailsModel basicDetails);
	
	public ResponseBuilder deleteUser(String contact);
	
}
