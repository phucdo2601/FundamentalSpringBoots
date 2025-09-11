package com.web.phucdn.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.GeneralStatusDto;
import com.web.phucdn.models.GeneralStatus;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.GeneralStatusRepository;
import com.web.phucdn.services.IGeneralStatusService;

@Service
public class GeneralStatusService implements IGeneralStatusService {

	@Autowired
	private GeneralStatusRepository generalStatusRepository;

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public BaseRepository<GeneralStatus> getRepository() {
		// TODO Auto-generated method stub
		return generalStatusRepository;
	}

	@Override
	public GeneralStatusDto convertEntityToDto(GeneralStatus t) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

		GeneralStatusDto generalStatusDto = new GeneralStatusDto();
		generalStatusDto = modelMapper.map(t, GeneralStatusDto.class);

		return generalStatusDto;
	}

	@Override
	public GeneralStatus convertDtoToEntity(GeneralStatusDto c) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

		GeneralStatus generalStatus = new GeneralStatus();
		generalStatus = modelMapper.map(c, GeneralStatus.class);

		return generalStatus;
	}

}
