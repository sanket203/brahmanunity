package com.brahmanunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.QualificationModel;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.repository.QualificationRepository;
import com.brahmanunity.service.QualificationDetailsService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class QualificationServiceImpl implements QualificationDetailsService{

	@Autowired
	QualificationRepository qualificationRepository;
	
	@Autowired
	BasicDetailsRepository basicDetailsRepository;

	@Override
	public ResponseBuilder addQualificationDetails(QualificationModel qualificationModel) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  QualificationModel qualificationDetail = qualificationRepository.save(qualificationModel);
			  if(qualificationDetail != null) {
				  BasicDetailsModel candidateDetails = basicDetailsRepository.getCandidateDetails(qualificationDetail.getCandidateId());
				  if(candidateDetails != null) {
					  if(!qualificationDetail.getDegree().equals(candidateDetails.getEducation())) {
						  candidateDetails.setEducation(qualificationDetail.getDegree());
						  basicDetailsRepository.save(candidateDetails);
					  }
				  }
			  }
			  response.setMessage(ResponseMessageConstants.SUCCESS_MESSAGE);
			  response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder getQualificationDetails(int candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  QualificationModel candidateQualificationDetails = qualificationRepository.getCandidateQualificationDetails(candidateId);
			  if(candidateQualificationDetails != null) {
				  response.setObject(candidateQualificationDetails);
			  } else {
				  response.setMessage(ResponseMessageConstants.NO_DATA_AVAILABLE);
			  }
			response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch(Exception ex) {
			response.setMessage(ex.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		
		return response;
	}
	
}
