package com.phucdn.jobportal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.jobportal.dto.UserDTO;
import com.phucdn.jobportal.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserApi {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		userDTO = userService.registerUser(userDTO);
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}
}
