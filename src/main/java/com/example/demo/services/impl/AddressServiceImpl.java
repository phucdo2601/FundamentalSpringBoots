package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address saveAdress(Address address) {
		return addressRepository.save(address);
	}
	
	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}
	
	@Override
	public Address getAddressById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}
	
	@Override
	public String deleteEmployeeById(Long id) {
		addressRepository.deleteById(id);
		return "Address remove !!" +id;
	}
	
	@Override
	public Address updateAddress(Address address) {
		Address existingAdd = addressRepository.findById(address.getAddressId()).orElse(null);
		existingAdd.setAddressType(address.getAddressType());
		existingAdd.setCity(address.getCity());
		Address addUdpdate = addressRepository.save(existingAdd);
		return addUdpdate;
	}
}
