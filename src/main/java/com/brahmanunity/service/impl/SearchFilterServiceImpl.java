package com.brahmanunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.pojo.FilterDTO;
import com.brahmanunity.repository.BasicDetailsRepository;
import com.brahmanunity.service.SearchFilterService;
import com.brahmanunity.utils.ResponseBuilder;

@Service

public class SearchFilterServiceImpl implements SearchFilterService {
	
	@Autowired
	BasicDetailsRepository basicRepository;

	@Override
	public ResponseBuilder searchByName(FilterDTO nameFilter) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			 String name = nameFilter.getFirstName() + " " + nameFilter.getLastName();
			 List<BasicDetailsModel> nameFilteredSearch = basicRepository.getSearchedNamedData(name);
			 if(nameFilteredSearch.size() > 0) {
				 response.setObject(nameFilteredSearch);
			 } else {
				response.setMessage(ResponseMessageConstants.NO_NAME_FOUND); 
			 }
			 response.setStatus(ResponseMessageConstants.STATUS_200);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(ResponseMessageConstants.STATUS_500);
		}
		return response;
	}

	@Override
	public ResponseBuilder filterByAge(FilterDTO ageFilter, String pageId) {
		ResponseBuilder response = new ResponseBuilder();
		try {
			  int minYear = Integer.parseInt(ageFilter.getMinAge());
			  int maxYear = Integer.parseInt(ageFilter.getMaxAge());
			  String gender = null;
			  if(ageFilter.getGender().equals("male")) {
				  gender="female";
			  } else {
				gender="male";
			  }
			  int page = Integer.parseInt(pageId);
			  PageRequest pageRequest = PageRequest.of(page, 4, Direction.DESC, "lastLogin");
			  Pageable pageable = pageRequest;
			  List<BasicDetailsModel> ageFilteredSearch = basicRepository.getDataByAgeDifference(gender, minYear, maxYear,pageable);
			  if(ageFilteredSearch.size() > 0) {
					 response.setObject(ageFilteredSearch);
				 } else {
					response.setMessage(ResponseMessageConstants.NO_NAME_FOUND); 
				 }
				 response.setStatus(ResponseMessageConstants.STATUS_200);
			} catch (Exception e) {
				response.setMessage(e.getMessage());
				response.setStatus(ResponseMessageConstants.STATUS_500);
			}
		return response;
	}

}
