package com.phucdn.employeeapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.employeeapp.service.employee.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeDetailsById(@PathVariable(name = "id") Integer id) {
		var empDetail = employeeService.getEmployeeById(id);

		if (empDetail != null) {
			return ResponseEntity.status(HttpStatus.OK).body(empDetail);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with "+id+" not found!");
		}
	}
}
