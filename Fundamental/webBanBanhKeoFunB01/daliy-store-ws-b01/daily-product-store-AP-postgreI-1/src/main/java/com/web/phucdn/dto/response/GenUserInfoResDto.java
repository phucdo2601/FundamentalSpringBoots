package com.web.phucdn.dto.response;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import com.web.phucdn.dto.CustomerDto;
import com.web.phucdn.dto.StaffDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenUserInfoResDto implements Serializable {
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Timestamp dateOfBirth;
	private String gender;
	private String address;
	private UUID genRoleId;
	private CustomerDto customerInfoResDto;
	private StaffDto staffInfoResDto;
}
