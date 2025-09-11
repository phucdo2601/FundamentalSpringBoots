package com.web.phucdn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.request.CreateCustomerReqDto;
import com.web.phucdn.dto.response.CustomerInfoResDto;
import com.web.phucdn.services.ICustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	@Autowired
	private ICustomerService iCustomerService;

	@PostMapping("/sign-up")
	public ResponseEntity<?> createNewCustomer(@RequestBody CreateCustomerReqDto model) {
		CustomerInfoResDto customerRes = iCustomerService.createNewCustomer(model);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerRes);

	}
}
