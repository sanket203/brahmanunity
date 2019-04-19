package com.brahmanunity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.pojo.FilterDTO;
import com.brahmanunity.service.SearchFilterService;
import com.brahmanunity.utils.ResponseBuilder;

@RestController
public class SearchFilterController {
	
	@Autowired
	private SearchFilterService searchService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(UrlConstants.SEARCH_BY_NAME)
	public ResponseEntity<ResponseBuilder> searchByName(@RequestBody FilterDTO filterDTO) {
		ResponseBuilder resp = searchService.searchByName(filterDTO);
		return new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
	}
	
	@GetMapping(UrlConstants.FILTER_BY_AGE)
	public ResponseEntity<ResponseBuilder> searchByAge(@RequestBody FilterDTO filterDTO) {
		ResponseBuilder resp = searchService.filterByAge(filterDTO);
		return new ResponseEntity<ResponseBuilder>(resp, HttpStatus.OK);
	}
	
	
	

}
