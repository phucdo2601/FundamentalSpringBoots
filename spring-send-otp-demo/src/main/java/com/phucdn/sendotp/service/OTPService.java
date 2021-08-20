package com.phucdn.sendotp.service;


public interface OTPService {

	void clearOTP(String key);

	int getOTP(String key);

	int generateOTP(String key);
	
}
