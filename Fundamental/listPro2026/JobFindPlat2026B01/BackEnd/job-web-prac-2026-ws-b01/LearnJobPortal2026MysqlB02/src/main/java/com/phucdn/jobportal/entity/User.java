package com.phucdn.jobportal.entity;

import com.phucdn.jobportal.dto.AccountType;
import com.phucdn.jobportal.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", indexes = {
		@Index(name = "idx_email", columnList = "email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
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
