package com.web.phucdn.dto.response;

import java.io.Serializable;

import com.web.phucdn.models.GeneralUserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto implements Serializable {
	private String token;
	private GeneralUserInfo genUserInfoResDto;
}
