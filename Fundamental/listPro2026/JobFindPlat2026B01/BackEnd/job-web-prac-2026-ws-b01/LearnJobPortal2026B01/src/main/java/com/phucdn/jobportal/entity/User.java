package com.phucdn.jobportal.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.phucdn.jobportal.dto.AccountType;
import com.phucdn.jobportal.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	private String id;
	private String name;
	@Indexed(unique = true)
	private String email;
	private String password;
	private AccountType accountType;
	
	
	public UserDTO toDto() {
		return UserDTO.builder()
				.id(id)
				.name(name)
				.email(email)
				.password(password)
				.accountType(accountType).build();
	}
}
