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
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	/**
	 * Config restTempate on EmployeeService class manually, with set root uri
	 */
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	/**
	 * set base url on application.properties for calling calling api
	 * @param addressBaseUrl
	 * @param builder
	 */
//	@Value("${addresservice.base.url}")
//	private String addressBaseUrl;
	
	public EmployeeServiceImpl(@Value("${addresservice.base.url}") String addressBaseUrl, RestTemplateBuilder builder) {
		// TODO Auto-generated constructor stub
		System.out.println(addressBaseUrl);
		this.restTemplate = builder
				.rootUri(addressBaseUrl)
				.build();
	}
	
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
		 * In this situation, using this case for solving problem,
		 * set base url on application.properties for calling calling api
		 */
//			ResponseEntity<List<AddressResponse>> rateResponse =
//			        restTemplate.exchange(addressBaseUrl+"/address/{id}",
//			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<AddressResponse>>() {
//			            }, id);
//			ResponseEntity<List<AddressResponse>> rateResponse =
//			        restTemplate.exchange("/address/{id}",
//			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<AddressResponse>>() {
//			            }, id);
//			List<AddressResponse> addressResponses = rateResponse.getBody();
//			employeeResponse.setAddressResponse(addressResponses);
			
			// using webClient for calling api
			/**
			 * For response object model
			 */
//			AddressResponse addressResponse = webClient
//					.get()
//					.uri("/address/"+id)
//					.retrieve()
//					.bodyToMono(AddressResponse.class).block();
			
			/**
			 * For response list data
			 * Using Flux for calling api and after that, using the calling result  .collect(Collectors.toList())
					.share().block();
			 */
			Flux<AddressResponse> addressFlux = webClient
					.get()
					.uri("/address/"+id)
					.retrieve()
					.bodyToFlux(AddressResponse.class);
			
			List<AddressResponse> addressResponses = addressFlux.collect(Collectors.toList())
					.share().block();
			employeeResponse.setAddressResponse(addressResponses);
			
			return employeeResponse;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
