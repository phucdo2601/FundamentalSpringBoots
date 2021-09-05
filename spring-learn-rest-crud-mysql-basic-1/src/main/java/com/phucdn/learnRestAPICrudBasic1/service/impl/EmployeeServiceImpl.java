package com.phucdn.learnRestAPICrudBasic1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.learnRestAPICrudBasic1.entity.Employee;
import com.phucdn.learnRestAPICrudBasic1.repository.EmployeeRepository;
import com.phucdn.learnRestAPICrudBasic1.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee insertNewEmployee(Employee entity) {
		return employeeRepository.save(entity);
	}
	
	@Override
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Optional<Employee> findEmployeeById(String id) {
		return employeeRepository.findById(id);
	}
	
	@Override
	public void deleteById(String id) {
		employeeRepository.deleteById(id);
	}
}
