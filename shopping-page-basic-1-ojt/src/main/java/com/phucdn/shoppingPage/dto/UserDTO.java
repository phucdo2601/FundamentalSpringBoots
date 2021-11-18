package com.phucdn.shoppingPage.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String userId;
	private String password;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private String status;
	private Date dateOfCreate;
	private String roleId;
}
