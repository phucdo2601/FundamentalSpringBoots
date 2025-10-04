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
		userDto.setBranchId(savedUser.getBranch() != null ? savedUser.getBranch().getId() : 0);
		userDto.setStoreId(savedUser.getStore() != null ? savedUser.getStore().getId() : 0);
		
		return userDto;
	}
	
	public static User toEntity(UserDto userDto) {
		User createdUser = new User();
		createdUser.setEmail(userDto.getEmail());
		createdUser.setFullName(userDto.getFullName());
		createdUser.setRole(userDto.getRole());
		createdUser.setPhone(userDto.getPhone());
		createdUser.setCreatedDate(userDto.getCreatedDate());
		createdUser.setUpdatedDate(userDto.getUpdatedDate());
		createdUser.setLastLogin(userDto.getLastLogin());
		createdUser.setPassword(userDto.getPassword());
		
		return createdUser;
	}
}
