package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.dto.UserDTO;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.exception.UserException;
import com.phucdn.learnSpringSecurity.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/users")
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<UserDTO> loadAllUsers() {
		List<UserDTO> listReturn = new ArrayList<>();
		List<UserEntity> listAllUser = userService.findAll();
		for (UserEntity userEntity : listAllUser) {
			String userId = userEntity.getUserId();
			String password = userEntity.getPassword();
			String fullName = userEntity.getFullName();
			String phone = userEntity.getPhone();
			String email = userEntity.getEmail();
			String address = userEntity.getAddress();
			Date dateOfCreate = userEntity.getDateOfCreate();
			String roleId = userEntity.getRoleUser().getRoleId();
			String status = userEntity.getStatus();
			listReturn.add(new UserDTO(userId, password, fullName, phone, email, address, status, dateOfCreate, roleId));
		}
		return listReturn;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") String userId) {
		UserEntity userEntity = 
				userService.findById(userId).orElseThrow(() -> new UserException("User does not exist with this id: "+userId));
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userEntity, userDTO);
		String roleId = userEntity.getRoleUser().getRoleId();
		userDTO.setRoleId(roleId);
		return ResponseEntity.ok(userDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") String userId) {
		UserEntity userEntity = 
				userService.findById(userId).orElseThrow(() -> new UserException("User does not exist with this id: "+userId));
		
		userService.delete(userEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/delO/{id}")
	public ResponseEntity<UserDTO> deleletUserOriginal(@PathVariable("id") String userId) {
		UserEntity userEntity = 
				userService.findById(userId).orElseThrow(() -> new UserException("User does not exist with this id: "+userId));
		userEntity.setStatus("InActive");
		UserEntity deleteUserO = userService.save(userEntity);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(deleteUserO, returnValue);
		String roleId = deleteUserO.getRoleUser().getRoleId();
		returnValue.setRoleId(roleId);
		return ResponseEntity.ok(returnValue);
	}
	
	@PutMapping("/reActO/{id}")
	public ResponseEntity<UserDTO> reActivateUserByUserId(@PathVariable("id") String userId) {
		UserEntity userEntity = 
				userService.findById(userId).orElseThrow(() -> new UserException("User does not exist with this id: "+userId));
		
		userEntity.setStatus("Active");
		UserEntity reActivateUserO = userService.save(userEntity);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(reActivateUserO, returnValue);
		String roleId = reActivateUserO.getRoleUser().getRoleId();
		returnValue.setRoleId(roleId);
		
		return ResponseEntity.ok(returnValue);
	}
}
