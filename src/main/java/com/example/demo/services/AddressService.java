package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Address;

public interface AddressService {

	Address updateAddress(Address address);

	String deleteEmployeeById(Long id);

	Address getAddressById(Long id);

	List<Address> getAllAddress();

	Address saveAdress(Address address);

}
