package com.brahmanunity.utils;

import com.brahmanunity.model.LoginDetailsModel;

public class ObjectConvertor {
	
	public static LoginDetailsModel convertLoginDetails(com.brahmanunity.pojo.LoginDetailsDto loginPojo) {
		LoginDetailsModel loginDetailsModel = new LoginDetailsModel();
		loginDetailsModel.setUserName(loginPojo.getUserName());
		loginDetailsModel.setPassword(loginPojo.getPassword());
		return loginDetailsModel;
	}

}
