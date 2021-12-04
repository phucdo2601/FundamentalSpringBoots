package com.phucdn.learnSpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.dto.DataInputDto;
import com.phucdn.learnSpringSecurity.entity.EmployeeDeparmentEntity;
import com.phucdn.learnSpringSecurity.repository.DepartmentRepository;
import com.phucdn.learnSpringSecurity.repository.EmployeeRepostiory;
import com.phucdn.learnSpringSecurity.service.EmployeeDepartmentService;
import com.phucdn.learnSpringSecurity.utils.Constant;
import com.phucdn.learnSpringSecurity.utils.DateInstance;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeDeparmentController {

	@Autowired
	private EmployeeDepartmentService employeeDepartmentService;
	
	@Autowired
	private EmployeeRepostiory employeeRepostiory;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/empInDep")
	public ResponseEntity<?> getAllListEmpInDep() {
		
		return new ResponseEntity<>(employeeDepartmentService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/empInDep")
	public ResponseEntity<?> addEmpInDep(@RequestBody EmployeeDeparmentEntity employeeDeparmentEntity) {
		employeeDeparmentEntity.setDateOfCreate(DateInstance.getCurrentTime());
		employeeDeparmentEntity.setStatus(Constant.EMPLOYEE_DEPARTMENT_DEMO.ACTIVATE_STATUS);
		return new ResponseEntity<>(employeeDepartmentService.save(employeeDeparmentEntity), HttpStatus.CREATED);
	}
	
	@GetMapping("/empInDep/findEmpByListEmpIds")
	public ResponseEntity<?> findEmployeeByListEmpId(@RequestBody DataInputDto dataInputDto) {
	     
	     return new ResponseEntity<>(employeeRepostiory.findByEmpIdIn(dataInputDto.getIds()), HttpStatus.OK);
	}
	
	@GetMapping("/empInDep/findDepByListDepIds")
	public ResponseEntity<?> findDepByDepListDepId(@RequestBody List<String> ids) {
		DataInputDto dataInputDto = new DataInputDto();
			dataInputDto.setIds(ids);
		return new ResponseEntity<>(departmentRepository.findByDepIdIn(dataInputDto.getIds()), HttpStatus.OK);
	}
}
