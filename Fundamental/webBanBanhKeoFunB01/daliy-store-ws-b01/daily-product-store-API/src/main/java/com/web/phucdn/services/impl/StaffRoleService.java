package com.web.phucdn.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.StaffRoleDto;
import com.web.phucdn.models.StaffRole;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.StaffRoleRepository;
import com.web.phucdn.services.IStaffRoleService;

@Service
public class StaffRoleService implements IStaffRoleService {

	@Autowired
	private StaffRoleRepository staffRoleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseRepository<StaffRole> getRepository() {
		// TODO Auto-generated method stub
		return staffRoleRepository;
	}

	@Override
	public StaffRoleDto convertEntityToDto(StaffRole t) {
		// TODO Auto-generated method stub

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		StaffRoleDto staffRoleDto = new StaffRoleDto();
		staffRoleDto = modelMapper.map(t, StaffRoleDto.class);

		return staffRoleDto;
	}

	@Override
	public StaffRole convertDtoToEntity(StaffRoleDto c) {
		// TODO Auto-generated method stub

		StaffRole staffRole = new StaffRole();
		staffRole = modelMapper.map(c, StaffRole.class);
		return staffRole;
	}

}
