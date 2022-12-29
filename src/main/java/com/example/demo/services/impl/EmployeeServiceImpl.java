package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	public String deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		return "Product removed !!" +id;
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Employee existingEmp = employeeRepository.findById(emp.getEmpId()).orElse(null);
		existingEmp.setAddress(emp.getAddress());
		existingEmp.setEmpAge(emp.getEmpAge());
		existingEmp.setEmpName(emp.getEmpName());
		Employee empUpdate = employeeRepository.save(existingEmp);
		return empUpdate;
	}
}
