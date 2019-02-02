package com.brahmanunity.service;

import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.utils.ResponseBuilder;

public interface PersonalDetailsService {
	
	public ResponseBuilder getRecord(int id);

	public ResponseBuilder saveRecord(PersonalDetailsDTO personalDetails);
	
	public ResponseBuilder deleteRecord(int id);
	
	public ResponseBuilder register(PersonalDetailsDTO personalDetails);
}
