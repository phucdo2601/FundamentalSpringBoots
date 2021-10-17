package com.phucdn.practicebackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.practicebackend.entity.UserEntity;
import com.phucdn.practicebackend.exception.UserException;
import com.phucdn.practicebackend.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<UserEntity> getAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") String id) {
		UserEntity user = userService.findById(id)
				.orElseThrow(() -> new UserException("User not exist with this id: " + id));
		return ResponseEntity.ok(user);
	}

	@PostMapping("")
	public UserEntity createUser(@RequestBody UserEntity userEntity) {
		return userService.save(userEntity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("id") String id, @RequestBody UserEntity userDetails) {
		UserEntity userE = userService.findById(id)
				.orElseThrow(() -> new UserException("User not exist with this id: " + id));
		userE.setFullName(userDetails.getFullName());
		userE.setPassword(userDetails.getPassword());
		userE.setRoleId(userDetails.getRoleId());
		UserEntity updateUser = userService.save(userE);
		return ResponseEntity.ok(updateUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") String id) {
		UserEntity user = userService.findById(id)
				.orElseThrow(() -> new UserException("User not exist with this id: " + id));
		userService.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
