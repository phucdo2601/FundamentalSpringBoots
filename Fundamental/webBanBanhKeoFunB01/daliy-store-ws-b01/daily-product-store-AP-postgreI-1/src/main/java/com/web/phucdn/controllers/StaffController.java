package com.web.phucdn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.StaffDto;
import com.web.phucdn.dto.request.CreateStaffReqDto;
import com.web.phucdn.dto.response.StaffInfoResDto;
import com.web.phucdn.models.Staff;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IStaffService;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController extends BaseController<Staff, StaffDto, IStaffService> {

	public StaffController(BaseService<Staff, StaffDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private IStaffService iStaffService;

	@PostMapping("/create-new-staff")
	public ResponseEntity<?> createNewStaff(@RequestBody CreateStaffReqDto model) {
		StaffInfoResDto staffInfoResDto = iStaffService.createNewStaff(model);
		return ResponseEntity.status(HttpStatus.CREATED).body(staffInfoResDto);
	}
}
