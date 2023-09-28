package com.phucdn.employeeapp.service.employee;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.employeeapp.dto.response.EmployeeResponse;
import com.phucdn.employeeapp.model.Employee;
import com.phucdn.employeeapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Employee> getAllEmployees() {
		var listResults = employeeRepository.findAll();
		return listResults;
	}
	
	@Override
	public EmployeeResponse getEmployeeById(Integer id) {
		Employee employee = employeeRepository.findById(id).get();
		
		//Manually
//		EmployeeResponse employeeResponse = new EmployeeResponse();
//		employeeResponse.setId(employee.getId());
//		employeeResponse.setName(employee.getName());
//		employeeResponse.setEmail(employee.getEmail());
//		employeeResponse.setBloodGroup(employee.getBloodgroup());
		
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		
		return employeeResponse;
	}
}
