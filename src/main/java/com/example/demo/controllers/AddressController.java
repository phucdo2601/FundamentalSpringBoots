package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;
import com.example.demo.services.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody Address address) {
		return addressService.saveAdress(address);
	}
	
	@GetMapping("/getListAddress")
	public List<Address> getListAddress() {
		return addressService.getAllAddress();
	}
	
	@GetMapping("/getAddresstById/{id}")
	public Address findProductById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}
	
	@PutMapping("/updateAddress")
	public Address updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public String deleteAddressById(@PathVariable Long id) {
		return addressService.deleteEmployeeById(id);
	}
	

}
