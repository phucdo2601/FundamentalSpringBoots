package com.phucdn.payload.dto;

import java.time.LocalDateTime;

import com.phucdn.domain.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String fullName;
	private String email;
	private String phone;
	private UserRole role;
	private String password;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private LocalDateTime lastLogin;
}
