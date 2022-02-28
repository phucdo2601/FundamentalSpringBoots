package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.phucdn.learnSpringSecurity.dto.RoleOfUserDTO;
import com.phucdn.learnSpringSecurity.entity.RoleOfUserEntity;
import com.phucdn.learnSpringSecurity.exception.RoleOfUserException;
import com.phucdn.learnSpringSecurity.service.RoleOfUserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Admin Role of user")
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/roleOfUser")
public class AdminRoleOfUserController {

	@Autowired
	private RoleOfUserService roleOfUserService;
	
	@GetMapping("")
	public List<RoleOfUserDTO> loadAllRoleOfUser() {
		List<RoleOfUserEntity> listAllRole = roleOfUserService.findAll();
		List<RoleOfUserDTO> listRoleReturn = new ArrayList<>();
		for (RoleOfUserEntity roleEtity : listAllRole) {
			String roleId = roleEtity.getRoleId();
			String roleName = roleEtity.getRoleName();
			Date dateOfCreate = roleEtity.getDateOfCreate();
			String description = roleEtity.getDescription();
			String status = roleEtity.getStatus();
			listRoleReturn.add(new RoleOfUserDTO(roleId, roleName, dateOfCreate, description, status));
		}
		return listRoleReturn;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleOfUserDTO> getRoleUserById(@PathVariable("id") String id) {
		Optional<RoleOfUserEntity> roleOfUser = roleOfUserService.findById(id);
		RoleOfUserDTO roleOfUserDTO = new RoleOfUserDTO();
		roleOfUserDTO.setRoleId(roleOfUser.get().getRoleId());
		roleOfUserDTO.setRoleName(roleOfUser.get().getRoleName());
		roleOfUserDTO.setDescription(roleOfUser.get().getDescription());
		roleOfUserDTO.setDateOfCreate(roleOfUser.get().getDateOfCreate());
		roleOfUserDTO.setStatus(roleOfUser.get().getStatus());
		return ResponseEntity.ok(roleOfUserDTO);
	}
	
	@PostMapping("")
	public RoleOfUserEntity createRoleOfUser(@RequestBody RoleOfUserEntity roleOfUserEntity) {
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		roleOfUserEntity.setDateOfCreate(dateOfCreate);
		roleOfUserEntity.setStatus("Active");
		return roleOfUserService.save(roleOfUserEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleOfUserEntity> updateRoleOfUser(@PathVariable("id") String id, @RequestBody RoleOfUserEntity roleEntity) {
		RoleOfUserEntity roleOfUserEntity = 
				roleOfUserService.findById(id).orElseThrow(() -> new RoleOfUserException("Role of User not exist with this id:"+id));
		
		roleOfUserEntity.setRoleName(roleEntity.getRoleName());
		roleOfUserEntity.setDescription(roleEntity.getDescription());
		
		RoleOfUserEntity updateRoleOfUser = roleOfUserService.save(roleOfUserEntity);
		
		return ResponseEntity.ok(updateRoleOfUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoleOfUser(@PathVariable("id") String roleId) {
		RoleOfUserEntity roleOfUserEntity = roleOfUserService.findById(roleId).orElseThrow(() -> new RoleOfUserException("Role of User does not exist with this id: " + roleId));
		roleOfUserService.delete(roleOfUserEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/delO/{id}")
	public ResponseEntity<RoleOfUserEntity> deleteRoleOfUserOriginal(@PathVariable("id") String roleId) {
		RoleOfUserEntity roleOfUserEntity = 
				roleOfUserService.findById(roleId).orElseThrow(() -> new RoleOfUserException("Role of User not exist with this id:"+roleId));
		
		roleOfUserEntity.setStatus("InActive");
		
		RoleOfUserEntity deleteRoleOfUserO = roleOfUserService.save(roleOfUserEntity);
		
		return ResponseEntity.ok(deleteRoleOfUserO);
	}
}
