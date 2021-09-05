package com.phucdn.learnRestAPICrudBasic1.service;

import java.util.List;
import java.util.Optional;

import com.phucdn.learnRestAPICrudBasic1.entity.Employee;
import com.phucdn.learnRestAPICrudBasic1.model.EmployeeDto;

public interface EmployeeService {

	Employee insertNewEmployee(Employee entity);

	void deleteById(String id);

	Optional<Employee> findEmployeeById(String id);

	List<Employee> findAllEmployees();


}
