package com.brahmanunity.service;

import org.springframework.web.multipart.MultipartFile;

import com.brahmanunity.utils.ResponseBuilder;

public interface PhotoHandlerService {
	
	public ResponseBuilder storeFile(MultipartFile[] files, String candidateId);
	
}
