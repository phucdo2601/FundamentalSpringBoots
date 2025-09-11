package com.web.phucdn.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.GeneralRoleDto;
import com.web.phucdn.models.GeneralRole;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.GeneralRoleRepository;
import com.web.phucdn.services.IGeneralRoleService;

@Service
public class GeneralRoleService implements IGeneralRoleService {

	@Autowired
	private GeneralRoleRepository generalRoleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseRepository<GeneralRole> getRepository() {
		// TODO Auto-generated method stub
		return generalRoleRepository;
	}

	@Override
	public GeneralRoleDto convertEntityToDto(GeneralRole t) {
		// TODO Auto-generated method stub
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		GeneralRoleDto generalRoleDto = new GeneralRoleDto();
		generalRoleDto = modelMapper.map(t, GeneralRoleDto.class);
		return null;
	}

	@Override
	public GeneralRole convertDtoToEntity(GeneralRoleDto c) {
		// TODO Auto-generated method stub
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		GeneralRole generalRole = new GeneralRole();
		generalRole = modelMapper.map(c, GeneralRole.class);
		return generalRole;
	}

}
