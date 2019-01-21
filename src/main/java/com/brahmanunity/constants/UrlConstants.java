package com.brahmanunity.constants;

public class UrlConstants {
	
	public static final String BASE_URL = "/bramhanunity";
	
	public static final String LOGIN_URL = BASE_URL+"/matrimony/login";
	
	public static final String CHECK_USER = BASE_URL+"/checkUser/{mobile}";
	
	public static final String GET_LATEST_PROFILES = BASE_URL+"/latestProfile/{gender}/{pageId}";
	
	public static final String ADD_PERSONAL_DETAILS = BASE_URL+"/savePersonalDetails";
	
	public static final String GET_PERSONAL_DETAILS = BASE_URL+"/getPersonalDetails/{candidateId}";
	
	public static final String DELETE_PRSONAL_DETAILS = BASE_URL+"/deletePersonalDetails/{id}";
	
    public static final String ADD_PHYSICAL_DETAILS = BASE_URL+"/savePhysicalDetails";
	
	public static final String GET_PHYSICAL_DETAILS = BASE_URL+"/getPhysicalDetails/{candidateId}";
	
	public static final String ADDRESS_TAKEN_PROFILE = BASE_URL+"/addressTakenProfiles/{userId}/{pageId}";
	
	public static final String SAVE_QUALIFICATION = BASE_URL+"/saveQualification";
	
	public static final String GET_QUALIFICATION = BASE_URL+"/getQualificationDetails/{candidateId}";
	
    public static final String SAVE_ABROAD_DETAILS = BASE_URL+"/saveAbroadDetails";
	
	public static final String GET_ABROAD_DETAILS = BASE_URL+"/getAbroadDetails/{candidateId}";
	
    public static final String SAVE_ADDRESS_DETAILS = BASE_URL+"/saveAddressDetails";
	
	public static final String GET_ADDRESS_DETAILS = BASE_URL+"/getAddressDetails/{candidateId}";
	
    public static final String SAVE_DIET_DETAILS = BASE_URL+"/saveDietDetails";
	
	public static final String GET_DIET_DETAILS = BASE_URL+"/getDietDetails/{candidateId}";
	
    public static final String SAVE_FAMILY_DETAILS = BASE_URL+"/saveFamilyDetails";
	
	public static final String GET_FAMILY_DETAILS = BASE_URL+"/getFamilyDetails/{candidateId}";
	
    public static final String SAVE_HOROSCOPE_DETAILS = BASE_URL+"/saveHoroscopeDetails";
	
	public static final String GET_HOROSCOPE_DETAILS = BASE_URL+"/getHoroscopeDetails/{candidateId}";
	
    public static final String SAVE_SERVICE_DETAILS = BASE_URL+"/saveServiceDetails";
	
	public static final String GET_SERVICE_DETAILS = BASE_URL+"/getServiceDetails/{candidateId}";
	
    public static final String SAVE_EXPECTATION_DETAILS = BASE_URL+"/saveExpectationDetails";
	
	public static final String GET_EXPECTATION_DETAILS = BASE_URL+"/getExpectationDetails/{candidateId}";
	
	public static final String LOGOUT = BASE_URL+"/logout";
	
	public static final String CHANGE_PASSWORD = BASE_URL+"/changePassword";
	
	public static final String SAVE_PHOTOS = BASE_URL+"/uploadFiles";

}

