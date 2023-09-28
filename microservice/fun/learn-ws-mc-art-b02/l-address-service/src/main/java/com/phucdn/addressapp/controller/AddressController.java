package com.phucdn.addressapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.addressapp.dto.response.AddressResponse;
import com.phucdn.addressapp.service.address.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping("/address/{employeeId}")
	public ResponseEntity<?> getAddressByEmployeeId(@PathVariable(name = "employeeId") Integer id) {
		List<AddressResponse> addressResponses = new ArrayList<>();
		addressResponses = addressService.findAddressByEmpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponses);
	}
}
