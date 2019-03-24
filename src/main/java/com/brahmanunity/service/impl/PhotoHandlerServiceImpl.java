package com.brahmanunity.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.service.PhotoHandlerService;
import com.brahmanunity.utils.ResponseBuilder;

@Service
public class PhotoHandlerServiceImpl implements PhotoHandlerService{
	
	public ResponseBuilder storeFile(MultipartFile[] files, String candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		String filePath = ResponseMessageConstants.IMAGE_PATH+candidateId;

        try {
        	 File file = new File(filePath);
        	 if(!file.exists()) {
        		 file.mkdirs();
        	 }
        	 
        	 for (MultipartFile multipartFile : files) {
        		 byte[] bytes = multipartFile.getBytes();
                 Path path = Paths.get(filePath + ResponseMessageConstants.FILE_SEPARATOR + multipartFile.getOriginalFilename());
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

	@Override
	public ResponseBuilder getImageFile(String candidateId) {
		ResponseBuilder response = new ResponseBuilder();
		String filePath = ResponseMessageConstants.IMAGE_PATH+candidateId;
		File file = new File(filePath);
		
		if(file.exists()) {
			File[] files = file.listFiles();
			if(files.length > 0) {
				String[] imagePathUrls = new String[files.length];
				for(int i=0;i<files.length;i++) {
					StringBuffer sb = new StringBuffer(UrlConstants.FILE_PATH_URL);
					sb.append(ResponseMessageConstants.FILE_SEPARATOR);
					sb.append(candidateId);
					sb.append(ResponseMessageConstants.FILE_SEPARATOR);
					sb.append(files[i].getName());
					imagePathUrls[i] = sb.toString();
				}
				response.setObject(Arrays.asList(imagePathUrls));
				response.setStatus(ResponseMessageConstants.STATUS_200);
				
			} else {
				response.setMessage(ResponseMessageConstants.NO_PHOTOS);
				response.setStatus(ResponseMessageConstants.STATUS_500);
			}
		} else {
			response.setMessage(ResponseMessageConstants.NO_PHOTOS);
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}
	
}
