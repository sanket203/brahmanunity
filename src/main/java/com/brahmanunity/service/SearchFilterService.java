package com.brahmanunity.service;

import com.brahmanunity.pojo.FilterDTO;
import com.brahmanunity.utils.ResponseBuilder;

public interface SearchFilterService {
	
	public ResponseBuilder searchByName(FilterDTO nameFilter);
	
	public ResponseBuilder filterByAge(FilterDTO heightFilter);

}
