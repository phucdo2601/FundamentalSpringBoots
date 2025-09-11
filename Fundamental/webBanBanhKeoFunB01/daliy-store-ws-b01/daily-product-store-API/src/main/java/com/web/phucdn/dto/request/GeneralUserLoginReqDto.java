package com.web.phucdn.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUserLoginReqDto implements Serializable {
	private String userName;
	private String password;
}
