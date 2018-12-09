package com.brahmanunity.service;

import com.brahmanunity.model.DietDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface DietDetailsService {
	
	public ResponseBuilder saveDietDetails(DietDetailsModel dietDetails);
	
	public ResponseBuilder getDietDetails(int candidateId);

}
