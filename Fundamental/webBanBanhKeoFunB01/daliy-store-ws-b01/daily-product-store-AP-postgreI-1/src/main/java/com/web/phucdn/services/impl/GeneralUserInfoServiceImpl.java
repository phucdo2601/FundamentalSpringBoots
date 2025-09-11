package com.web.phucdn.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.GeneralUserInfoDto;
import com.web.phucdn.dto.request.CreateGeneralUserReqDto;
import com.web.phucdn.dto.response.GenUserInfoResDto;
import com.web.phucdn.models.GeneralUserInfo;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.GeneralUserInfoRepository;
import com.web.phucdn.services.IGeneralUserInfoService;

@Service
public class GeneralUserInfoServiceImpl implements IGeneralUserInfoService {

	@Autowired
	private GeneralUserInfoRepository generalUserInfoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseRepository<GeneralUserInfo> getRepository() {
		// TODO Auto-generated method stub
		return generalUserInfoRepository;
	}

	@Override
	public GeneralUserInfoDto convertEntityToDto(GeneralUserInfo t) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		GeneralUserInfoDto generalUserInfoDto = new GeneralUserInfoDto();
		generalUserInfoDto = modelMapper.map(t, GeneralUserInfoDto.class);
		return generalUserInfoDto;
	}

	@Override
	public GeneralUserInfo convertDtoToEntity(GeneralUserInfoDto c) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		GeneralUserInfo generalUserInfo = new GeneralUserInfo();
		generalUserInfo = modelMapper.map(c, GeneralUserInfo.class);

		return generalUserInfo;
	}

	@Override
	public GenUserInfoResDto createNewAccount(CreateGeneralUserReqDto model) {
		// TODO Auto-generated method stub
		return null;
	}

}
