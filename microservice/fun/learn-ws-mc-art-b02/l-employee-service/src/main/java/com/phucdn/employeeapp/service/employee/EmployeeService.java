package com.phucdn.employeeapp.service.employee;

import java.util.List;

import com.phucdn.employeeapp.dto.response.EmployeeResponse;
import com.phucdn.employeeapp.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	EmployeeResponse getEmployeeById(Integer id);

}
