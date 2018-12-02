package com.brahmanunity.utils;

import com.brahmanunity.model.MatrimonyLogin;

public class ObjectConvertor {
	
	public static MatrimonyLogin convertLoginDetails(com.brahmanunity.pojo.LoginDetailsDto loginPojo) {
		MatrimonyLogin loginDetailsModel = new MatrimonyLogin();
		loginDetailsModel.setUser_name(loginPojo.getUser_name());
		loginDetailsModel.setPassword(loginPojo.getPassword());
		return loginDetailsModel;
	}

}
