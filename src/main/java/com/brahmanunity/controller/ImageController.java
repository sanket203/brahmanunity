package com.brahmanunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.service.PhotoHandlerService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class ImageController {

	@Autowired
    private PhotoHandlerService fileStorageService;
    
    @PostMapping(UrlConstants.SAVE_PHOTOS)
    public ResponseEntity<ResponseBuilder> uploadFile(@RequestParam("files") MultipartFile[] files, @RequestParam("candidateId") String candidateId) {
        ResponseBuilder resp = fileStorageService.storeFile(files,candidateId);
        ResponseEntity<ResponseBuilder> response = new ResponseEntity<ResponseBuilder>(resp,HttpStatus.OK);
        return response;
    }


}
