package com.phucdn.employeeapp.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phucdn.employeeapp.dto.response.AddressResponse;

//http://localhost:8081/address-app/api/address/1
@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-app/api")
public interface AddressClient {
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<?> getAddressByEmployeeId(@PathVariable(name = "employeeId") Integer id);
}
