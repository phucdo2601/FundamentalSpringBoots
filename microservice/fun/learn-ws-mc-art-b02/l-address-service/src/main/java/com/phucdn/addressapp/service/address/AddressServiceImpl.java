package com.phucdn.addressapp.service.address;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.addressapp.dto.response.AddressResponse;
import com.phucdn.addressapp.model.Address;
import com.phucdn.addressapp.repository.AddressRepository;


@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<AddressResponse> findAddressByEmpId(Integer employeeId) {
		List<Address> addresses = addressRepository.findAddressByEmployeeId(employeeId);
		List<AddressResponse> listReturn = new ArrayList<>();
		for (Address address : addresses) {
			AddressResponse addressReturn = modelMapper.map(address, AddressResponse.class);
			listReturn.add(addressReturn);
		}
		return listReturn;
	}
	
}
