package com.brahmanunity.service;

import com.brahmanunity.model.FamilyDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface FamilyDetailsService {
	
	public ResponseBuilder saveFamilyDetails(FamilyDetailsModel familyDetails);
	
	public ResponseBuilder getFamilyDetails(int candidateId);

}
