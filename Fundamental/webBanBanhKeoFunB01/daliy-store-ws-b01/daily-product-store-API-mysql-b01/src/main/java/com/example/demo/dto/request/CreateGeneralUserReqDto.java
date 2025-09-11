package com.example.demo.dto.request;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGeneralUserReqDto implements Serializable {
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Date dateOfBirth;
	private String gender;
	private String address;
	private UUID genRoleId;
}
