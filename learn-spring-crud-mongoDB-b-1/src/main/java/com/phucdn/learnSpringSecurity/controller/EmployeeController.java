package com.phucdn.learnSpringSecurity.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;
import com.phucdn.learnSpringSecurity.exception.EmployeeException;
import com.phucdn.learnSpringSecurity.service.EmployeeService;
import com.phucdn.learnSpringSecurity.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployee() {
		
		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long empId) {
		
		Optional<EmployeeEntity> empOptional = employeeService.findById(empId);
		
		return empOptional.map(emp -> ResponseEntity.ok().body(emp)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeEntity> createNewEmp(@RequestBody EmployeeEntity employeeEntity) {
		
		employeeEntity.setId(sequenceGeneratorService.generateSequence(EmployeeEntity.SEQUENCE_NAME));
		
		return new ResponseEntity<EmployeeEntity>(employeeService.save(employeeEntity), HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") Long empId, 
			@RequestBody EmployeeEntity employeeDetail) {
		
		Optional<EmployeeEntity> empOptional = employeeService.findById(empId);
		
		return empOptional.map(emp -> {
			emp.setEmailId(employeeDetail.getEmailId());
			emp.setFirstName(employeeDetail.getFirstName());
			emp.setLastName(employeeDetail.getLastName());
			final EmployeeEntity updateEmp = employeeService.save(emp);
			return new ResponseEntity<>(updateEmp, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") Long empId) {
		
		EmployeeEntity employeeEntity = employeeService.findById(empId).orElseThrow(() -> 
				new EmployeeException("Employee does not exist with this id!"));
		
		employeeService.delete(employeeEntity);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
