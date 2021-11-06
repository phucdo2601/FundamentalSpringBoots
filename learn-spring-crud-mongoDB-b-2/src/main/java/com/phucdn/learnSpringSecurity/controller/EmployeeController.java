package com.phucdn.learnSpringSecurity.controller;

import java.util.Date;
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

import com.phucdn.learnSpringSecurity.entity.DepartmentEntity;
import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;
import com.phucdn.learnSpringSecurity.exception.DepartmentException;
import com.phucdn.learnSpringSecurity.exception.EmployeeException;
import com.phucdn.learnSpringSecurity.repository.DepartmentRepository;
import com.phucdn.learnSpringSecurity.repository.EmployeeRepostiory;
import com.phucdn.learnSpringSecurity.service.DepartmentService;
import com.phucdn.learnSpringSecurity.service.EmployeeService;
import com.phucdn.learnSpringSecurity.service.SequenceGeneratorService;
import com.phucdn.learnSpringSecurity.utils.Constant;
import com.phucdn.learnSpringSecurity.utils.DateInstance;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepostiory employeeRepostiory;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployee() {

		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") String empId) {

		Optional<EmployeeEntity> empOptional = employeeRepostiory.findByEmpId(empId);

		return empOptional.map(emp -> ResponseEntity.ok().body(emp))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/employees")
	public ResponseEntity<EmployeeEntity> createNewEmp(@RequestBody EmployeeEntity employeeEntity) {
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		employeeEntity.setDateOfCreate(dateOfCreate);
		return new ResponseEntity<EmployeeEntity>(employeeService.save(employeeEntity), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") String empId,
			@RequestBody EmployeeEntity employeeDetail) {

		Optional<EmployeeEntity> empOptional = employeeRepostiory.findByEmpId(empId);

		return empOptional.map(emp -> {
			emp.setEmailId(employeeDetail.getEmailId());
			emp.setFirstName(employeeDetail.getFirstName());
			emp.setLastName(employeeDetail.getLastName());
			final EmployeeEntity updateEmp = employeeService.save(emp);
			return new ResponseEntity<>(updateEmp, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmpByEmpId(@PathVariable(value = "id") String empId) {

		EmployeeEntity employeeEntity = employeeRepostiory.findByEmpId(empId)
				.orElseThrow(() -> new EmployeeException("Employee does not exist with this id!"));

		employeeService.delete(employeeEntity);
		Map<String, Boolean> response = new HashMap<>();

		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/departments")
	public ResponseEntity<?> getAllDepartments() {
		return new ResponseEntity<>(departmentRepository.getAllDepartmentWithActivateStatus(), HttpStatus.OK);
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<?> getDepartmentByDepartmentId(@PathVariable("id") String depId) {
		Optional<DepartmentEntity> findDepByDepId = departmentRepository.findByDepId(depId);

		return findDepByDepId.map(dep -> ResponseEntity.ok().body(dep))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/departments")
	public ResponseEntity<?> createNewDep(@RequestBody DepartmentEntity depEntity) {
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);

		depEntity.setDateOfCreate(dateOfCreate);
		depEntity.setStatus(Constant.DEPARTMENT_DEMO.ACTIVATE_STATUS);
		return new ResponseEntity<>(departmentService.save(depEntity), HttpStatus.OK);
	}

	@PutMapping("/departments/{id}")
	public ResponseEntity<?> updateDepartmentByDepId(@PathVariable("id") String depId,
			@RequestBody DepartmentEntity departmentEntity) {
		Optional<DepartmentEntity> depOptional = departmentRepository.findByDepId(depId);

		return depOptional.map(dep -> {
			dep.setDepName(departmentEntity.getDepName());
			dep.setUpdateBy(departmentEntity.getUpdateBy());
			dep.setStatus(Constant.DEPARTMENT_DEMO.ACTIVATE_STATUS);
			dep.setDateOfUpdate(DateInstance.getCurrentTime());
			dep.setDescription(departmentEntity.getDescription());
			final DepartmentEntity updateDepartment = departmentService.save(dep);
			return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<?> deleteDepartmentByDepId(@PathVariable("id") String depId) {
		DepartmentEntity departmentEntity = departmentRepository.findByDepId(depId)
				.orElseThrow(() -> new DepartmentException("Department does not exsit with this id:" + depId));

		departmentService.delete(departmentEntity);
		Map<String, Boolean> response = new HashMap<>();

		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/departments/banDep/{id}")
	public ResponseEntity<?> banDepartmentByDeptId(@PathVariable("id") String depId) {
		DepartmentEntity departmentEntity = departmentRepository.findByDepId(depId)
				.orElseThrow(() -> new DepartmentException("Department does not exsit with this id:" + depId));
		
		Optional<DepartmentEntity> banDep = departmentService.changeStatusOfDepartment(depId, Constant.DEPARTMENT_DEMO.IN_ACTICATE_STATUS);
		
		return new ResponseEntity<>(banDep, HttpStatus.OK);
		
	}
}
