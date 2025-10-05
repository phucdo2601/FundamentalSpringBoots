package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.model.Customer;
import com.phucdn.repository.CustomerRepository;
import com.phucdn.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCreatedDate(LocalDateTime.now());
		customer.setUpdatedDate(LocalDateTime.now());
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) throws Exception {
		Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new Exception("Customer not found"));
		
		customerToUpdate.setFullName(customer.getFullName());
		customerToUpdate.setEmail(customer.getEmail());
		customerToUpdate.setPhone(customer.getPhone());
		customerToUpdate.setUpdatedDate(LocalDateTime.now());
		return customerRepository.save(customerToUpdate);
	}

	@Override
	public void deleteCustomer(Long id) throws Exception {
		Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new Exception("Customer not found"));
		customerRepository.delete(customerToUpdate);
	}

	@Override
	public Customer getCustomer(Long id) throws Exception {
		Customer customerById = customerRepository.findById(id).orElseThrow(() -> new Exception("Customer not found"));
		return customerById;
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> searchCustomers(String keyword) throws Exception {
		return customerRepository.findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
	}

}
