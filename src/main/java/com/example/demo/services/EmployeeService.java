package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {

	Employee updateEmployee(Employee emp);

	String deleteEmployeeById(Long id);

	Employee getEmployeeById(Long id);

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee emp);

}
