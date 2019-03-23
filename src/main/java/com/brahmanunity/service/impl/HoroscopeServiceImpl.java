package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.HoroscopeDetailsModel;
import com.brahmanunity.repository.HoroscopeDetailsRepository;
import com.brahmanunity.service.HoroscopeService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class HoroscopeServiceImpl implements HoroscopeService {
	
	@Autowired
	HoroscopeDetailsRepository horoscopeRepository;

	@Override
	public ResponseBuilder saveHoroscopeDetails(HoroscopeDetailsModel horoscopeDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  horoscopeRepository.save(horoscopeDetails);
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
			} catch(Exception ex) {
				response.setMessage(ex.getMessage());
				response.setStatus(ResponseMessageConstants.STATUS_500);
			}
		return response;
	}

	@Override
	public ResponseBuilder getHoroscopeDetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  HoroscopeDetailsModel horoscopeDetails = horoscopeRepository.getHoroscopeDetails(candidateId);
			  if(horoscopeDetails != null) {
				  response.setObject(horoscopeDetails);
				  response.setStatus(ResponseMessageConstants.STATUS_200);
			  } else {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
				  response.setStatus(ResponseMessageConstants.STATUS_500);
			  }
			 
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}
	

}
