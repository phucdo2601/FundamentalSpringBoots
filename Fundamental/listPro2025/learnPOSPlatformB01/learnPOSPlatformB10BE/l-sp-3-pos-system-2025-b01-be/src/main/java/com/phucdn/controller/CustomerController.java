package com.phucdn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.model.Customer;
import com.phucdn.payload.response.ApiResponse;
import com.phucdn.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@PostMapping()
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.createCustomer(customer));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(
			@PathVariable Long id
			, @RequestBody Customer customer) throws Exception {
		return ResponseEntity.ok(customerService.updateCustomer(id, customer));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(
			@PathVariable Long id) throws Exception {
		customerService.deleteCustomer(id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Delete customer successfully!");
		
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(
			@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(customerService.getCustomer(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<Customer>> getAllCustomers() throws Exception {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Customer>> searchCustomer(@RequestParam String q) throws Exception {
		return ResponseEntity.ok(customerService.searchCustomers(q));
	}
}
