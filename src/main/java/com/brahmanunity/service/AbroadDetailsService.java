package com.brahmanunity.service;

import com.brahmanunity.model.AbroadDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface AbroadDetailsService {
	
	public ResponseBuilder saveAbroadDetails(AbroadDetailsModel abroadDetails);
	
	public ResponseBuilder getAbroadDetails(int candidateId);

}
