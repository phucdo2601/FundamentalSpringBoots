package com.phucdn.learnSpringSecurity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;
import com.phucdn.learnSpringSecurity.exception.EmployeeException;
import com.phucdn.learnSpringSecurity.repository.EmployeeRepostiory;
import com.phucdn.learnSpringSecurity.service.EmployeeService;
import com.phucdn.learnSpringSecurity.utils.CommonUtils;
import com.phucdn.learnSpringSecurity.utils.Constant;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepostiory employeeRepostiory;
	
//	private MapperS

	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployee() {

		CommonUtils.autoCreatePassword();
		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") String empId) {
		LOGGER.info("Find employee By emp_id: " + empId);
		LOGGER.trace("This is TRACE");
		LOGGER.debug("This is DEBUG");
		LOGGER.info("This is INFO");
		LOGGER.warn("This is WARN");
		LOGGER.error("This is ERROR");
		Optional<EmployeeEntity> empOptional = employeeRepostiory.findByEmpId(empId);

		return empOptional.map(emp -> ResponseEntity.ok().body(emp))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/employees")
	public ResponseEntity<EmployeeEntity> createNewEmp(@RequestBody EmployeeEntity employeeEntity) {
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		employeeEntity.setDateOfCreate(dateOfCreate);
		employeeEntity.setStatus(Constant.EMPLOYEE_DEMO.ACTIVATE_STATUS);
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

	@GetMapping("/employees/findLikeFirstNameOrEmail")
	public ResponseEntity<?> findLikeFirstNameOrEmailId(@RequestParam("search") String search) {

		List<EmployeeEntity> listSearch = employeeRepostiory.findEmployeeByFirstNameOrEmailId(search);

		return new ResponseEntity<>(listSearch, HttpStatus.OK);
	}

	@GetMapping("/employees/findLikeFirstNameOrEmailPaging")
	public ResponseEntity<?> findLikeFirstNameOrEmailIdWithPaging(
			@RequestParam(value = "search", required = true) String search,
			@RequestParam(value = "pSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "page", required = false, defaultValue = "0") Optional<Integer> pageNum) {

		int pageInput = pageNum.get().intValue();
		if (pageInput < 0) {
			return new ResponseEntity<>("This page num is not correct. Please Input Again(Greater than 1)!",
					HttpStatus.NOT_FOUND);
		} else {
			
			List<EmployeeEntity> listReturn = new ArrayList<>();
			Pageable paging;
			if (pageNum.isEmpty()) {
				paging = PageRequest.ofSize(pageSize);
			} else {
				paging = PageRequest.of(pageInput, pageSize);
			}

			Page<EmployeeEntity> pageEmps = employeeRepostiory.findEmployeeeByFirstNameOrEmailIdPaging(search, paging);

			listReturn = pageEmps.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("currentPage", pageEmps.getNumber());
			response.put("employees", listReturn);			
			response.put("totalItems", pageEmps.getTotalElements());
			response.put("totalPages", pageEmps.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/employees/tLoadListEmp1")
	public ResponseEntity<?> testLoadListEmp1() {
		List<EmployeeEntity> listReturn = employeeService.findAll().stream()
				.collect(Collectors.toList());
		return new ResponseEntity<>(listReturn, HttpStatus.OK);
	}
}
