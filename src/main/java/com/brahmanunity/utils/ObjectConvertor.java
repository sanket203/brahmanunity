package com.brahmanunity.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.brahmanunity.constants.ResponseMessageConstants;
import com.brahmanunity.constants.UrlConstants;
import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.model.BasicDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
import com.brahmanunity.model.PersonalDetailsModel;
import com.brahmanunity.pojo.AddressTakenDto;
import com.brahmanunity.pojo.BasicDetailsDto;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.pojo.ProfileAddressDto;

public class ObjectConvertor {

	public static MatrimonyLogin convertLoginDetails(com.brahmanunity.pojo.LoginDetailsDto loginPojo) {
		MatrimonyLogin loginDetailsModel = new MatrimonyLogin();
		loginDetailsModel.setUser_name(loginPojo.getUser_name());
		loginDetailsModel.setPassword(loginPojo.getPassword());
		return loginDetailsModel;
	}

	public static PersonalDetailsModel convertPersonalDetails(PersonalDetailsDTO personalDetailsDto) {
		PersonalDetailsModel personalDetails = new PersonalDetailsModel();
		if (personalDetailsDto.getId() != 0) {
			personalDetails.setId(personalDetailsDto.getId());
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			if (personalDetailsDto.getBirthDate() != null) {
				Date dateTime = formatter.parse(personalDetailsDto.getBirthDate());
				personalDetails.setBirthDate(dateTime);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		personalDetails.setAboutMe(personalDetailsDto.getAboutMe());
		personalDetails.setBirthPlace(personalDetailsDto.getBirthPlace());
		personalDetails.setBirthTime(personalDetailsDto.getBirthTime());
		personalDetails.setFirstName(personalDetailsDto.getFirstName());
		personalDetails.setGender(personalDetailsDto.getGender());
		personalDetails.setMotherTongue(personalDetailsDto.getMotherTongue());
		personalDetails.setMiddleName(personalDetailsDto.getMiddleName());
		personalDetails.setLastName(personalDetailsDto.getLastName());
		personalDetails.setHobbies(personalDetailsDto.getHobbies());
		personalDetails.setMaritalStatus(personalDetailsDto.getMaritalStatus());
		personalDetails.setRegisterBy(personalDetailsDto.getRegisterBy());
		personalDetails.setReligion(personalDetailsDto.getReligion());

		return personalDetails;
	}

	public static PersonalDetailsDTO convertPersonalDetailsDTO(PersonalDetailsModel personalDetailsDto) {
		PersonalDetailsDTO personalDetails = new PersonalDetailsDTO();
		if (personalDetailsDto.getId() != 0) {
			personalDetails.setId(personalDetailsDto.getId());
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			if (personalDetailsDto.getBirthDate() != null) {
				String format = formatter.format(personalDetailsDto.getBirthDate().getTime());
				personalDetails.setBirthDate(format);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		personalDetails.setAboutMe(personalDetailsDto.getAboutMe());
		personalDetails.setBirthPlace(personalDetailsDto.getBirthPlace());
		personalDetails.setBirthTime(personalDetailsDto.getBirthTime());
		personalDetails.setFirstName(personalDetailsDto.getFirstName());
		personalDetails.setGender(personalDetailsDto.getGender());
		personalDetails.setMotherTongue(personalDetailsDto.getMotherTongue());
		personalDetails.setMiddleName(personalDetailsDto.getMiddleName());
		personalDetails.setLastName(personalDetailsDto.getLastName());
		personalDetails.setHobbies(personalDetailsDto.getHobbies());
		personalDetails.setMaritalStatus(personalDetailsDto.getMaritalStatus());
		personalDetails.setRegisterBy(personalDetailsDto.getRegisterBy());
		personalDetails.setReligion(personalDetailsDto.getReligion());

		return personalDetails;
	}

	public static ProfileAddressDto convertAddressModelToAddress(List<AddressDetailsModel> alladdressDetails,
			boolean b) {
		ProfileAddressDto profileAddress = new ProfileAddressDto();
		List<AddressTakenDto> addressList = new ArrayList<AddressTakenDto>();
		alladdressDetails.forEach(item -> {
			AddressTakenDto address = new AddressTakenDto();
			address.setAddress(item.getAddress());
			address.setContact(item.getContact());
			address.setAlternateNumber(item.getAlternateNumber());
			address.setCandidateId(item.getCandidateId());
			addressList.add(address);
		});
		profileAddress.setAddressExist(b);
		profileAddress.setAllAddress(addressList);
		return profileAddress;
	}

	public static BasicDetailsDto convertBasicdetailsToBasicDTO(BasicDetailsModel basicDetails) {
		BasicDetailsDto basicDTO = new BasicDetailsDto();
		basicDTO.setName(basicDetails.getName());
		basicDTO.setCandidateId(basicDetails.getCandidateId());
		basicDTO.setAddressCount(basicDetails.getAddressCount());
		basicDTO.setEducation(basicDetails.getEducation());
		basicDTO.setGender(basicDetails.getGender());
		basicDTO.setHeight(basicDetails.getHeight());
		basicDTO.setIncome(String.valueOf(basicDetails.getIncome()));
		basicDTO.setId(basicDetails.getId());
		basicDTO.setStatus(basicDetails.getStatus());
		basicDTO.setRegistered(basicDetails.getRegistered());
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			if (basicDetails.getBirthDate() != null) {
				String dateOfBirth = formatter.format(basicDetails.getBirthDate().getTime());
				basicDTO.setBirthDate(dateOfBirth);
			}
			if (basicDetails.getLastLogin() != null) {
				String lastLogin = formatter.format(basicDetails.getLastLogin().getTime());
				basicDTO.setLastLogin(lastLogin);
			}
			String imageUrl = null;
			String filePath = ResponseMessageConstants.IMAGE_PATH + basicDetails.getCandidateId();
			File file = new File(filePath);
			if (file.exists()) {
				File[] listFiles = file.listFiles();
				if(listFiles.length > 0) {
					imageUrl = UrlConstants.FILE_PATH_URL+basicDetails.getCandidateId()+ResponseMessageConstants.FILE_SEPARATOR+listFiles[0].getName();
				}
			}
			basicDTO.setImageUrl(imageUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return basicDTO;
	}

}
