package com.phucdn.jobportal.service;

import com.phucdn.jobportal.dto.LoginDTO;
import com.phucdn.jobportal.dto.UserDTO;
import com.phucdn.jobportal.exception.JobPortalException;

public interface UserService {
	public UserDTO registerUser(UserDTO userDTO) throws JobPortalException;
	
	public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException;
	
	public Boolean sendOtp(String email) throws Exception;
	
	public Boolean verifyOtp(String emai, String otp) throws JobPortalException;
}
