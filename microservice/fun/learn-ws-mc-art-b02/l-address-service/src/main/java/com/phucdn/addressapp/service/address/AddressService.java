package com.phucdn.addressapp.service.address;

import java.util.List;

import com.phucdn.addressapp.dto.response.AddressResponse;

public interface AddressService {

	List<AddressResponse> findAddressByEmpId(Integer employeeId);

}
