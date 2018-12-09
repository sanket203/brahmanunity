package com.brahmanunity.service;

import com.brahmanunity.model.PhysicalDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface PhysicalDetailsService {
	
	public ResponseBuilder saveRecord(PhysicalDetailsModel physicalDetails);
	
	public ResponseBuilder getRecord(int candidateId);
	
	public ResponseBuilder deleteRecord(int id);

}
