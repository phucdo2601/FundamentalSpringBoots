package com.web.phucdn.services;

import com.web.phucdn.dto.CustomerDto;
import com.web.phucdn.dto.request.CreateCustomerReqDto;
import com.web.phucdn.dto.response.CustomerInfoResDto;
import com.web.phucdn.models.Customer;

public interface ICustomerService extends BaseService<Customer, CustomerDto> {
	public CustomerInfoResDto createNewCustomer(CreateCustomerReqDto model);
}
