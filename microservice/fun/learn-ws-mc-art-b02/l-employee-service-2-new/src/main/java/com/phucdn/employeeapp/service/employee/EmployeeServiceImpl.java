package com.phucdn.employeeapp.service.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.phucdn.employeeapp.dto.response.AddressResponse;
import com.phucdn.employeeapp.dto.response.EmployeeResponse;
import com.phucdn.employeeapp.feignclient.AddressClient;
import com.phucdn.employeeapp.model.Employee;
import com.phucdn.employeeapp.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressClient addressClient;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		var listResults = employeeRepository.findAll();
		return listResults;
	}
	
	@Override
	public EmployeeResponse getEmployeeById(Integer id) {
		
		try {
			Employee employee = employeeRepository.findById(id).get();
			
			EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
			
			ResponseEntity<?> addressResponsesEntity = addressClient.getAddressByEmployeeId(id);
			
			List<AddressResponse> addressResponses =  (List<AddressResponse>) addressResponsesEntity.getBody();
			
			employeeResponse.setAddressResponse(addressResponses);
			
			return employeeResponse;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
