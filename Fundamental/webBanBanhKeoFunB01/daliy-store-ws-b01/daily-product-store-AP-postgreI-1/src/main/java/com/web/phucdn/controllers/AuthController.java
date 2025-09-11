package com.web.phucdn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.request.CreateUserReqDto;
import com.web.phucdn.dto.request.GeneralUserLoginReqDto;
import com.web.phucdn.dto.response.AuthenticationResponseDto;
import com.web.phucdn.services.IAuthService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

	@Autowired
	private IAuthService iAuthService;

	@PostMapping("/general-login")
	public ResponseEntity<?> generalLogin(@RequestBody GeneralUserLoginReqDto model) {
		AuthenticationResponseDto generalUserInfo = iAuthService.checkLogin(model.getUserName(), model.getPassword());

		return ResponseEntity.status(HttpStatus.OK).body(generalUserInfo);

	}

	@PostMapping("/general-signup")
	public ResponseEntity<?> generalSignUpUser(@RequestBody CreateUserReqDto model) {
		AuthenticationResponseDto generalUserInfo = iAuthService.registerCustomer(model);

		return ResponseEntity.status(HttpStatus.OK).body(generalUserInfo);
	}
}
