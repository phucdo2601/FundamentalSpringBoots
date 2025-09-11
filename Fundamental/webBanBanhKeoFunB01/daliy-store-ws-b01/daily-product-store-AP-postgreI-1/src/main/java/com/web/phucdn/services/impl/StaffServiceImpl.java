package com.web.phucdn.services.impl;

import java.time.ZoneId;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.StaffDto;
import com.web.phucdn.dto.request.CreateStaffReqDto;
import com.web.phucdn.dto.response.StaffInfoResDto;
import com.web.phucdn.helper.GeneralHelper;
import com.web.phucdn.models.GeneralUserInfo;
import com.web.phucdn.models.Staff;
import com.web.phucdn.models.StaffRole;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.StaffRepository;
import com.web.phucdn.repositories.StaffRoleRepository;
import com.web.phucdn.services.IGeneralUserInfoService;
import com.web.phucdn.services.IStaffService;

@Service
public class StaffServiceImpl implements IStaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffRoleRepository staffRoleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IGeneralUserInfoService iGeneralUserInfoService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final ZoneId ZONE_ID = ZoneId.of("Asia/Bangkok");

	@Override
	public BaseRepository<Staff> getRepository() {
		// TODO Auto-generated method stub
		return staffRepository;
	}

	@Override
	public StaffDto convertEntityToDto(Staff t) {
		// set up for model maper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		StaffDto staffDto = new StaffDto();
		staffDto = modelMapper.map(t, StaffDto.class);
		return staffDto;
	}

	@Override
	public Staff convertDtoToEntity(StaffDto c) {
		// set up for model maper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Staff staff = new Staff();
		staff = modelMapper.map(c, Staff.class);
		return staff;
	}

	@Override
	public StaffInfoResDto createNewStaff(CreateStaffReqDto model) {
		// TODO Auto-generated method stub
		/**
		 * Basic set up staff data model
		 */

		GeneralUserInfo genUserInfoStaff = GeneralHelper.setUpDataOnGenUserInfoOfStaff(model, ZONE_ID);

		GeneralUserInfo createdUserInfoOfStaff = iGeneralUserInfoService.create(genUserInfoStaff);

		/**
		 * Create staff info
		 */
		Staff staff = new Staff();
		staff.setGeneralUserInfo(createdUserInfoOfStaff);

		// Basic set up staff-role of Staff info
		StaffRole staffRole = staffRoleRepository.findById(model.getStaffRoleId()).get();

		staff.setStaffRole(staffRole);

		// estimate of creating customer code;
		staff.setStaffCode("ss-0001");

		Staff staffCreated = staffRepository.save(staff);

		// Staff-Info return model

		StaffInfoResDto staffInfoResDto = new StaffInfoResDto();
		staffInfoResDto.setFullName(createdUserInfoOfStaff.getFullName());
		staffInfoResDto.setUserName(createdUserInfoOfStaff.getUsername());
		staffInfoResDto.setEmail(createdUserInfoOfStaff.getEmail());
		staffInfoResDto.setPhoneNumber(createdUserInfoOfStaff.getPhoneNumber());
		staffInfoResDto.setNationalId(createdUserInfoOfStaff.getNationalId());
		staffInfoResDto.setDateOfBirth(createdUserInfoOfStaff.getDateOfBirth());
		staffInfoResDto.setGender(createdUserInfoOfStaff.getGender());
		staffInfoResDto.setAddress(createdUserInfoOfStaff.getAddress());
		staffInfoResDto.setGenRoleId(createdUserInfoOfStaff.getGeneralRole().getId());
		staffInfoResDto.setActive(createdUserInfoOfStaff.isActive());
		staffInfoResDto.setStaffCode(staffCreated.getStaffCode());

		return staffInfoResDto;
	}

}
