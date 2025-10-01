package com.phucdn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.exceptions.UserException;
import com.phucdn.mapper.UserMapper;
import com.phucdn.model.User;
import com.phucdn.payload.dto.UserDto;
import com.phucdn.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<UserDto> getUserProfile(@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.getUserFromJwtToken(jwt);
		return ResponseEntity.ok(UserMapper.toDto(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@RequestHeader("Authorization") String jwt, @PathVariable("id") Long id) throws UserException, Exception {
		User user = userService.getUserById(id);
		
		return ResponseEntity.ok(UserMapper.toDto(user));
	}
}
