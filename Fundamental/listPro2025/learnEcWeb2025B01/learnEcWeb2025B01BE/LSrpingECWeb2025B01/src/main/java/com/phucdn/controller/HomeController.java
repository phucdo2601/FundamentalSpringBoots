package com.phucdn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.response.ApiResponse;

@RestController

public class HomeController {
	@GetMapping
	public ApiResponse homeControllerHandler() {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Welcome to ecommerce multi vendor system" );
		return apiResponse;
	}
}
