package com.phucdn.learnRestAPICrudBasic1.controller;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnRestAPICrudBasic1.entity.Employee;
import com.phucdn.learnRestAPICrudBasic1.model.EmployeeDto;
import com.phucdn.learnRestAPICrudBasic1.repository.EmployeeRepository;
import com.phucdn.learnRestAPICrudBasic1.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	private Employee addNewEmployee(@RequestBody EmployeeDto empdto) {
		Employee entity = new Employee();
		BeanUtils.copyProperties(empdto, entity);
		return employeeService.insertNewEmployee(entity);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
//		Employee entity = new Employee();
//		EmployeeDto dto  = new EmployeeDto();
//		BeanUtils.copyProperties(entity, dto);
//		List<Employee> listEmp = 
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") String id){
		Employee employee = employeeService.findEmployeeById(id)
				.orElseThrow(() -> new ResolutionException("Employee does not exist! Please input again!"));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") String empId, @RequestBody EmployeeDto empDto) {
		Employee empEntity= employeeService.findEmployeeById(empId)
				.orElseThrow(() -> new ResolutionException("Employee does not exsit with this id"));
		empEntity.setEmployeeName(empDto.getEmployeeName());
		empEntity.setEmail(empDto.getEmail());
		empEntity.setDateStart(empDto.getDateStart());
		Employee updateEmp = employeeService.insertNewEmployee(empEntity);
		return ResponseEntity.ok(updateEmp);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable("empId") String empId) {
		Employee empEntity= employeeService.findEmployeeById(empId)
				.orElseThrow(() -> new ResolutionException("Employee does not exsit with this id"));
		employeeService.deleteById(empId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
