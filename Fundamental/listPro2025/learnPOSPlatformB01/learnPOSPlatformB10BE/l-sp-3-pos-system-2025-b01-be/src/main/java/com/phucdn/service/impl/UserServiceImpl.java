package com.phucdn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.phucdn.configuration.JwtProvider;
import com.phucdn.exceptions.UserException;
import com.phucdn.model.User;
import com.phucdn.repository.UserRepository;
import com.phucdn.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public User getUserFromJwtToken(String token) throws UserException {
		String email = jwtProvider.getEmailFromToken(token);
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UserException("Invalid token");
		}
		
		return user;
	}

	@Override
	public User getCurrentUser() throws UserException {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UserException("Invalid token");
		}
		
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws UserException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UserException("Invalid token");
		}
		
		return user;
	}

	@Override
	public User getUserById(Long id) throws UserException, Exception {
		return userRepository.findById(id).orElseThrow(
				() -> new Exception("User not found!")
				);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
