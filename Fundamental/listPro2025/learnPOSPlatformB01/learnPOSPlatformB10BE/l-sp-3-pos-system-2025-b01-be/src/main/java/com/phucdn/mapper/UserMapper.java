package com.phucdn.mapper;

import com.phucdn.model.User;
import com.phucdn.payload.dto.UserDto;

public class UserMapper {

	public static UserDto toDto(User savedUser) {
		UserDto userDto = new UserDto();
		userDto.setId(savedUser.getId());
		userDto.setEmail(savedUser.getEmail());
		userDto.setFullName(savedUser.getFullName());
		userDto.setPhone(savedUser.getPhone());
		userDto.setRole(savedUser.getRole());
		userDto.setCreatedDate(savedUser.getCreatedDate());
		userDto.setUpdatedDate(savedUser.getUpdatedDate());
		userDto.setLastLogin(savedUser.getLastLogin());
		
		return userDto;
	}
}
