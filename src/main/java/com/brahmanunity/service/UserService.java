package com.brahmanunity.service;

import com.brahmanunity.pojo.LoginDetailsDto;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.utils.ResponseBuilder;

public interface UserService {
	
	public ResponseBuilder changePassword(String emailId, String password);
	
	public ResponseBuilder logoutUser();
	
	public ResponseBuilder validateUser(LoginDetailsDto loginDetailsDto);
	
	public ResponseBuilder checkUser(PersonalDetailsDTO personalDetailsDto);

}
