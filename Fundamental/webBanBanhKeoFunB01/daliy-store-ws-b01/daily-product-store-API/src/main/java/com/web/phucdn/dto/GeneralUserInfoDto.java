package com.web.phucdn.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUserInfoDto {
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Timestamp dateOfBirth;
	private String gender;
	private String address;
	private Timestamp dateOfCreate;
	private Timestamp dateOfLastUpdate;
	private String genRoleId;
}
