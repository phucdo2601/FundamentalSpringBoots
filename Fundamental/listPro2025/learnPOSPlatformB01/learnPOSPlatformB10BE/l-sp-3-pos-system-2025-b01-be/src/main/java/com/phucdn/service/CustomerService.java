package com.phucdn.service;

import java.util.List;

import com.phucdn.model.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);
	Customer updateCustomer(Long id, Customer customer) throws Exception;
	void deleteCustomer(Long id) throws Exception;
	Customer getCustomer(Long id) throws Exception;
	List<Customer> getAllCustomers() throws Exception;
	List<Customer> searchCustomers(String keyword) throws Exception;
}
