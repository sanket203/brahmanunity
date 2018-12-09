package com.brahmanunity.service;

import com.brahmanunity.model.QualificationModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface QualificationDetailsService {
	
	public ResponseBuilder addQualificationDetails(QualificationModel qualificationModel); 
	
	public ResponseBuilder getQualificationDetails(int candidateId); 

}
