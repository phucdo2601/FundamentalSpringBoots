package com.web.phucdn.services.impl;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.request.CreateUserReqDto;
import com.web.phucdn.dto.response.AuthenticationResponseDto;
import com.web.phucdn.helper.GeneralHelper;
import com.web.phucdn.models.Customer;
import com.web.phucdn.models.GeneralRole;
import com.web.phucdn.models.GeneralUserInfo;
import com.web.phucdn.models.Staff;
import com.web.phucdn.models.StaffRole;
import com.web.phucdn.repositories.CustomerRepository;
import com.web.phucdn.repositories.GeneralRoleRepository;
import com.web.phucdn.repositories.GeneralUserInfoRepository;
import com.web.phucdn.repositories.StaffRepository;
import com.web.phucdn.repositories.StaffRoleRepository;
import com.web.phucdn.services.IAuthService;
import com.web.phucdn.services.IGeneralUserInfoService;
import com.web.phucdn.services.IJwtService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private GeneralUserInfoRepository generalUserInfoRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private GeneralRoleRepository generalRoleRepository;

	@Autowired
	private StaffRoleRepository staffRoleRepository;

	@Autowired
	private IJwtService iJwtService;

	@Autowired
	private IGeneralUserInfoService iGeneralUserInfoService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	private static final ZoneId ZONE_ID = ZoneId.of("Asia/Bangkok");

	@Override
	public AuthenticationResponseDto checkLogin(String userName, String password) {
		// TODO Auto-generated method stub
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		/*
		 * System.out.println( authenticationManager.authenticate(new
		 * UsernamePasswordAuthenticationToken(userName, password)));
		 */
		var user = generalUserInfoRepository.findByUserName(userName).orElseThrow();

		var jwtToken = iJwtService.generateToken(user);

		return AuthenticationResponseDto.builder().token(jwtToken).genUserInfoResDto(user).build();
	}

	@Override
	public AuthenticationResponseDto registerCustomer(CreateUserReqDto model) {
		// TODO Auto-generated method stub

//		String passwordDesrypt = passwordEncoder.encode(model.getPassword());
//		model.setPassword(passwordDesrypt);

		GeneralUserInfo genUserInfo = GeneralHelper.setUpDataOnGeneralUserInfo(model, ZONE_ID);

		GeneralUserInfo createdGenUserInfo = iGeneralUserInfoService.create(genUserInfo);

		GeneralRole generalRole = createdGenUserInfo.getGeneralRole();

		GeneralRole customerGenRole = generalRoleRepository.findCustomerRoleOfGenRole();
		GeneralRole staffGenRole = generalRoleRepository.findStaffRoleOfGenRole();

		if (generalRole.getId().equals(customerGenRole.getId())) {
			Customer customer = new Customer();
			customer.setCustomerCode("cus-0002");
			customer.setCustomerPoint(0.0f);
			customer.setGeneralUserInfo(genUserInfo);

			Customer customerCreated = customerRepository.save(customer);
		} else {
			Staff staff = new Staff();
			staff.setStaffCode("st-00001");

			StaffRole staffRole = staffRoleRepository.getDefaultStaffRole();

			staff.setStaffRole(staffRole);

			Staff staffCreated = staffRepository.save(staff);

		}

		var jwtToken = iJwtService.generateToken(genUserInfo);

		return AuthenticationResponseDto.builder().token(jwtToken).genUserInfoResDto(genUserInfo).build();
	}

}
