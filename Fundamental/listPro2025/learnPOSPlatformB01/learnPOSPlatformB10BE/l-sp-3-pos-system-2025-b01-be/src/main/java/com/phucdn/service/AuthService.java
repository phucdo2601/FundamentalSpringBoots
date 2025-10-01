package com.phucdn.service;

import org.springframework.stereotype.Service;

import com.phucdn.exceptions.UserException;
import com.phucdn.payload.dto.UserDto;
import com.phucdn.payload.response.AuthResponse;

public interface AuthService {
	AuthResponse signUp(UserDto userDto) throws UserException;
	AuthResponse login(UserDto userDto) throws UserException;
}
