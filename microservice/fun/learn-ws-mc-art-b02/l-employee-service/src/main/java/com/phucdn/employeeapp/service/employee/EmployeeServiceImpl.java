package com.phucdn.employeeapp.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.phucdn.employeeapp.dto.response.AddressResponse;
import com.phucdn.employeeapp.dto.response.EmployeeResponse;
import com.phucdn.employeeapp.model.Employee;
import com.phucdn.employeeapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Employee> getAllEmployees() {
		var listResults = employeeRepository.findAll();
		return listResults;
	}
	
	@Override
	public EmployeeResponse getEmployeeById(Integer id) {
		
		try {
			Employee employee = employeeRepository.findById(id).get();
			
			//Manually for coverting entity to dto
//			EmployeeResponse employeeResponse = new EmployeeResponse();
//			employeeResponse.setId(employee.getId());
//			employeeResponse.setName(employee.getName());
//			employeeResponse.setEmail(employee.getEmail());
//			employeeResponse.setBloodGroup(employee.getBloodgroup());
			
			EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
			
			/**
			 * In that situation get an object for calling another service
			 */
//			obj = (List<AddressResponse>) restTemplate.get("http://localhost:8081/address-app/api/address/{id}", AddressResponse.class, id);
			
		/**
		 * In this situation, using this case for solcing problem
		 */
			ResponseEntity<List<AddressResponse>> rateResponse =
			        restTemplate.exchange("http://localhost:8081/address-app/api/address/{id}",
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<AddressResponse>>() {
			            }, id);
			List<AddressResponse> addressResponses = rateResponse.getBody();
			
			employeeResponse.setAddressResponse(addressResponses);
			
			return employeeResponse;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
