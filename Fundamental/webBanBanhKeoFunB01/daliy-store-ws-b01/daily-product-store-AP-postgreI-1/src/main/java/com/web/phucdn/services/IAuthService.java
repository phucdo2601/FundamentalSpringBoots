package com.web.phucdn.services;

import com.web.phucdn.dto.request.CreateUserReqDto;
import com.web.phucdn.dto.response.AuthenticationResponseDto;

public interface IAuthService {
	public AuthenticationResponseDto checkLogin(String userName, String password);

	public AuthenticationResponseDto registerCustomer(CreateUserReqDto model);
}
