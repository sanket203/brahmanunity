package com.brahmanunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.model.AddressTakenModel;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.pojo.ProfileAddressDto;
import com.brahmanunity.repository.AddressDetailsRepository;
import com.brahmanunity.repository.AddressTakenRepository;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.service.AddressDetailsService;
import com.brahmanunity.utils.ObjectConvertor;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class AddressDetailsServiceImpl implements AddressDetailsService {
	
	@Autowired
	AddressDetailsRepository addressRepository;
	
	@Autowired
	AddressTakenRepository addressTakenRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;

	@Override
	public ResponseBuilder saveAddressDetails(AddressDetailsModel addressDetails) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  addressRepository.save(addressDetails);
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception ex) {
			  response.setMessage(ex.getMessage());
			  response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getAddressdetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  List<AddressDetailsModel> allaAressDetails = addressRepository.getAlladdressDetails(candidateId);
			  response.setObject(allaAressDetails);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getAddressTakenProfiles(int userId, int pageId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			 PageRequest pageRequest = PageRequest.of(pageId, 10);
			 Pageable pageable = pageRequest;
			 List<Integer> profiles = addressTakenRepository.getMyAddressProfiles(userId, pageable);
			 if(profiles.size() == 0) {
				 response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
			 } else {
				 List<BasicDetailsModel> profilesList = basicDetailsRepository.findAllById(profiles);
				 response.setObject(profilesList);
			 }
			 response.setStatus(ResponseMessageConstants.STATUS_200);
			 
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		
		return response;
	}

	@Override
	public ResponseBuilder getProfileAddress(int userId, int profileId, boolean isAddressTaken) {
	    ResponseBuilder response = new ResponseBuilder();
	    List<AddressDetailsModel> alladdressDetails = new ArrayList<AddressDetailsModel>();
	    try {
	    	  if(isAddressTaken == false) {
	    		  AddressTakenModel checkAddress = addressTakenRepository.checkAddress(userId, profileId);
	    		  if(checkAddress == null) {
	    			  response.setObject(new Boolean(false));
	    		  } else {
	    			  alladdressDetails = addressRepository.getAlladdressDetails(profileId);
	    			  ProfileAddressDto profileAddress = ObjectConvertor.convertAddressModelToAddress(alladdressDetails,true);
	    	    	  response.setObject(profileAddress);
	    		  }
	    		  response.setStatus(ResponseMessageConstants.STATUS_200);
	    	  } else {
	    		  BasicDetailsModel userDetails = basicDetailsRepository.getCandidateDetails(userId);
	    		  if(userDetails.getAddressCount() > 0) {
	    			  alladdressDetails = addressRepository.getAlladdressDetails(profileId);
		    		  AddressTakenModel addressTaken = new AddressTakenModel();
		    		  addressTaken.setProfileId(profileId);
		    		  addressTaken.setUserId(userId);
		    		  addressTakenRepository.save(addressTaken);
	    		  }
	    		  userDetails.setAddressCount(userDetails.getAddressCount() - 1);
	    		  basicDetailsRepository.save(userDetails);
	    		  //TODO: reduce address count and entry in address taken profile.
		    	  response.setObject(alladdressDetails);
		    	  response.setStatus(ResponseMessageConstants.STATUS_200);
	    	  }
	    } catch(Exception ex) {
	    	response.setMessage(ex.getMessage());
	    	response.setStatus(ResponseMessageConstants.STATUS_500);
	    	
	    }
	    return response;
		
	}

}
