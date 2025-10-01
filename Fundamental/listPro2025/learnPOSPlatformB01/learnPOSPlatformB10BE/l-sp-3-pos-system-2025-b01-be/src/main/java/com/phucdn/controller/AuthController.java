package com.phucdn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.exceptions.UserException;
import com.phucdn.payload.dto.UserDto;
import com.phucdn.payload.response.AuthResponse;
import com.phucdn.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	// http://localhost:5000/auth/signup

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signUpHandler(@RequestBody UserDto userDto) throws UserException {
		return ResponseEntity.ok(authService.signUp(userDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> loginHandler(@RequestBody UserDto userDto) throws UserException {
		return ResponseEntity.ok(authService.login(userDto));
	}
}
