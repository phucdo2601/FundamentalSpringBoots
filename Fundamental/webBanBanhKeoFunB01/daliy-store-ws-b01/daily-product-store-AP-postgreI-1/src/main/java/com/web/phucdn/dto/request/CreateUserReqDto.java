package com.web.phucdn.dto.request;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserReqDto implements Serializable {
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Timestamp dateOfBirth;
	private String gender;
	private String address;
	private String genRoleId;
}
