package com.phucdn.jobportal.dto;

import com.phucdn.jobportal.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	private String id;
	private String name;
	private String email;
	private String password;
	private AccountType accountType;
	
	public User toEntity() {
		return User.builder()
				.id(id).name(name)
				.email(email).password(password)
				.accountType(accountType).build();
	}
}
