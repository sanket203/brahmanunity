package com.brahmanunity.pojo;

import java.util.List;

public class ProfileAddressDto
 {
	
	List<AddressTakenDto> allAddress;
	private boolean isAddressExist;
	
	public List<AddressTakenDto> getAllAddress() {
		return allAddress;
	}
	public void setAllAddress(List<AddressTakenDto> allAddress) {
		this.allAddress = allAddress;
	}
	public boolean isAddressExist() {
		return isAddressExist;
	}
	public void setAddressExist(boolean isAddressExist) {
		this.isAddressExist = isAddressExist;
	}
}
