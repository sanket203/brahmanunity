package com.brahmanunity.service;

import com.brahmanunity.model.HoroscopeDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface HoroscopeService {
	
	public ResponseBuilder saveHoroscopeDetails(HoroscopeDetailsModel horoscopeDetails);
	
	public ResponseBuilder getHoroscopeDetails(int candidateId);

}
