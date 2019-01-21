package com.brahmanunity.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.service.PhotoHandlerService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class PhotoHandlerServiceImpl implements PhotoHandlerService{
	
	public ResponseBuilder storeFile(MultipartFile[] files, String candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		String filePath = "D:/candidatePhotos/"+candidateId;

        try {
        	 File file = new File(filePath);
        	 if(!file.exists()) {
        		 file.mkdirs();
        	 }
        	 
        	 for (MultipartFile multipartFile : files) {
        		 byte[] bytes = multipartFile.getBytes();
                 Path path = Paths.get(filePath + "/" + multipartFile.getOriginalFilename());
                 Files.write(path, bytes);
			 }
            response.setMessage(ResponseMessageConstants.FILE_UPLOAD);
            response.setStatus(ResponseMessageConstants.STATUS_200);

        } catch (IOException ex) {
            response.setMessage(ex.getMessage());
            response.setStatus(ResponseMessageConstants.STATUS_500);
        }
        return response;
    }
	
}
