package com.brahmanunity.service;

import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.utils.ResponseBuilder;

public interface AddressDetailsService {
	
	public ResponseBuilder saveAddressDetails(AddressDetailsModel addressDetails);
	
	public ResponseBuilder getAddressdetails(int candidateId);
	
	public ResponseBuilder getAddressTakenProfiles(int userId, int pageId);
	
	public ResponseBuilder getProfileAddress(int userId, int profileId, boolean isAddressTaken);
	
}
