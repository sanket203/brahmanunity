package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.DietDetailsModel;
import com.brahmanunity.repository.DietDetailsRepository;
import com.brahmanunity.service.DietDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class DietDetailsServiceImpl implements DietDetailsService {
	
	@Autowired
	DietDetailsRepository dietRepository;

	@Override
	public ResponseBuilder saveDietDetails(DietDetailsModel dietDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  dietRepository.save(dietDetails);
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			response.setStatus(ResponseMessageConstants.STATUS_500);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBuilder getDietDetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		/*try {
			  DietDetailsModel dietDetails = dietRepository.getDietDetails(candidateId);
			  if(dietDetails != null) {
				  response.setObject(dietDetails);
			  } else {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
			  }
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}*/
		return response;
	}

}
