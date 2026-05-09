package com.phucdn.jobportal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phucdn.jobportal.dto.LoginDTO;
import com.phucdn.jobportal.dto.UserDTO;
import com.phucdn.jobportal.entity.User;
import com.phucdn.jobportal.exception.JobPortalException;
import com.phucdn.jobportal.repository.UserRepository;
import com.phucdn.jobportal.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDTO registerUser(UserDTO userDTO) throws JobPortalException {
		Optional<User> userExisted = userRepository.findByEmail(userDTO.getEmail());
		if (userExisted.isPresent()) {
			throw new JobPortalException("USER FOUND");
		}
		
		User user = userDTO.toEntity();
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user = userRepository.save(user);
		return user.toDto();
	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException {
		User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));
		
		if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
			throw new JobPortalException("INVALID_CREDENTIALS");
		}
		
		return user.toDto();
	}

}
