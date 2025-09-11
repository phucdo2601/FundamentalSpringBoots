package com.web.phucdn.services;

import com.web.phucdn.dto.GeneralUserInfoDto;
import com.web.phucdn.dto.request.CreateGeneralUserReqDto;
import com.web.phucdn.dto.response.GenUserInfoResDto;
import com.web.phucdn.models.GeneralUserInfo;

public interface IGeneralUserInfoService extends BaseService<GeneralUserInfo, GeneralUserInfoDto> {

	public GenUserInfoResDto createNewAccount(CreateGeneralUserReqDto model);
}
