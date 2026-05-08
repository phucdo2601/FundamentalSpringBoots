package com.phucdn.jobportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.jobportal.dto.UserDTO;
import com.phucdn.jobportal.entity.User;
import com.phucdn.jobportal.repository.UserRepository;
import com.phucdn.jobportal.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		User user = userDTO.toEntity();
		user = userRepository.save(user);
		return user.toDto();
	}

}
