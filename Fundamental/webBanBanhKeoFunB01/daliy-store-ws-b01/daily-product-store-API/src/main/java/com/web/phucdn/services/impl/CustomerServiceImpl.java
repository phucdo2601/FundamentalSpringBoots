package com.web.phucdn.services.impl;

import java.time.ZoneId;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.CustomerDto;
import com.web.phucdn.dto.request.CreateCustomerReqDto;
import com.web.phucdn.dto.response.CustomerInfoResDto;
import com.web.phucdn.helper.GeneralHelper;
import com.web.phucdn.models.Customer;
import com.web.phucdn.models.GeneralUserInfo;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.CustomerRepository;
import com.web.phucdn.repositories.GeneralRoleRepository;
import com.web.phucdn.repositories.GeneralUserInfoRepository;
import com.web.phucdn.services.ICustomerService;
import com.web.phucdn.services.IGeneralUserInfoService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private GeneralUserInfoRepository generalUserInfoRepository;

	@Autowired
	private GeneralRoleRepository generalRoleRepository;

	@Autowired
	private IGeneralUserInfoService iGeneralUserInfoService;

	private static final ZoneId ZONE_ID = ZoneId.of("Asia/Bangkok");

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseRepository<Customer> getRepository() {
		// TODO Auto-generated method stub
		return customerRepository;
	}

	@Override
	public CustomerDto convertEntityToDto(Customer t) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		CustomerDto customerDto = new CustomerDto();
		customerDto = modelMapper.map(t, CustomerDto.class);
		return customerDto;
	}

	@Override
	public Customer convertDtoToEntity(CustomerDto c) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Customer customer = new Customer();
		customer = modelMapper.map(c, Customer.class);
		return customer;
	}

	@Override
	public CustomerInfoResDto createNewCustomer(CreateCustomerReqDto model) {
		// Create General User Info
		/**
		 * Basic set up customer data model
		 */
		GeneralUserInfo genUserInfoModel = GeneralHelper.setUpDataOnGenUserInfoOfCus(model, ZONE_ID);

		GeneralUserInfo createdUserInfo = iGeneralUserInfoService.create(genUserInfoModel);

		/**
		 * Create customer info
		 */
		Customer customer = new Customer();
		customer.setGeneralUserInfo(createdUserInfo);

		// Basic create customer code
		customer.setCustomerCode("cus-00001");
		customer.setCustomerPoint(0.0f);
		customer.setLastPurchaseDate(null);

		Customer customerCreated = customerRepository.save(customer);

		CustomerInfoResDto customerInfoRes = new CustomerInfoResDto();
		customerInfoRes.setFullName(createdUserInfo.getFullName());
		customerInfoRes.setUserName(createdUserInfo.getUsername());
		customerInfoRes.setEmail(createdUserInfo.getEmail());
		customerInfoRes.setPhoneNumber(createdUserInfo.getPhoneNumber());
		customerInfoRes.setNationalId(createdUserInfo.getNationalId());
		customerInfoRes.setDateOfBirth(createdUserInfo.getDateOfBirth());
		customerInfoRes.setGender(createdUserInfo.getGender());
		customerInfoRes.setAddress(createdUserInfo.getAddress());
		customerInfoRes.setGenRoleId(createdUserInfo.getGeneralRole().getId());
		customerInfoRes.setActive(createdUserInfo.isActive());
		customerInfoRes.setCustomerCode(customerCreated.getCustomerCode());
		customerInfoRes.setCustomerPoint(customerCreated.getCustomerPoint());
		customerInfoRes.setLastPurchaseDate(customerCreated.getLastPurchaseDate());
		return customerInfoRes;
	}

}
