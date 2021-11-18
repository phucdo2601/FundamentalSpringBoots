package com.phucdn.learnSpringSecurity.controller.admin;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.dto.DiscountUserDTO;
import com.phucdn.learnSpringSecurity.entity.DiscountOfUserEntity;
import com.phucdn.learnSpringSecurity.entity.DiscountUserEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.exception.DiscountUserException;
import com.phucdn.learnSpringSecurity.service.DiscountUserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/discountUser")
public class AdminDiscountUserController {

	@Autowired
	private DiscountUserService discountUserService;
	
	@GetMapping("")
	public List<DiscountUserEntity> loadAllDiscountUser(){
		return discountUserService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiscountUserEntity> getDiscountUserById(@PathVariable("id") Integer id) {
		DiscountUserEntity discountUserEntity = 
				discountUserService.findById(id).orElseThrow(() -> new DiscountUserException("Discount User is does not have with this id: "+id));
		
		return ResponseEntity.ok(discountUserEntity);
	}
	
	@PostMapping("")
	public DiscountUserEntity createNewDiscountUser(@RequestBody DiscountUserDTO discountUserDTO) {
		DiscountUserEntity discountUserEntity = new DiscountUserEntity();
		BeanUtils.copyProperties(discountUserDTO, discountUserEntity);
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(discountUserDTO.getUserId());
		DiscountOfUserEntity discountOfUserEntity = new DiscountOfUserEntity();
		discountOfUserEntity.setDiscountId(discountUserDTO.getDiscountId());
		discountUserEntity.setDiscount(discountOfUserEntity);
		discountUserEntity.setUser(userEntity);
		Long mills = System.currentTimeMillis();
		Date dateOfAdd = new Date(mills);
		discountUserEntity.setDateOfAdd(dateOfAdd);
		discountUserEntity.setStatus("Active");
		
		return discountUserService.save(discountUserEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DiscountUserEntity> updateDiscountById(@PathVariable("id") Integer id, @RequestBody DiscountUserDTO discountUserDTO) {
		DiscountUserEntity discountUserEntity = 
				discountUserService.findById(id).orElseThrow(() -> new DiscountUserException("Discount User is does not have with this id: "+id));
		BeanUtils.copyProperties(discountUserDTO, discountUserEntity);
		Long mills = System.currentTimeMillis();
		Date dateOfUpdate = new Date(mills);
		discountUserEntity.setDateOfAdd(dateOfUpdate);
		DiscountOfUserEntity discountOfUserEntity = new DiscountOfUserEntity();
		discountOfUserEntity.setDiscountId(discountUserDTO.getDiscountId());
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(discountUserDTO.getUserId());
		
		discountUserEntity.setDiscount(discountOfUserEntity);
		discountUserEntity.setUser(userEntity);
		discountUserEntity.setStatus("Active");
		
		DiscountUserEntity updateDiscountUser = discountUserService.save(discountUserEntity);
		
		return ResponseEntity.ok(updateDiscountUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDiscountUser(@PathVariable("id") Integer id) {
		DiscountUserEntity discountUserEntity = 
				discountUserService.findById(id).orElseThrow(() -> new DiscountUserException("Discount User is does not have with this id: "+id));
		discountUserService.delete(discountUserEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/delO/{id}")
	public ResponseEntity<DiscountUserEntity> deleteDiscountUserOriginal(@PathVariable("id") Integer id) {
		DiscountUserEntity discountUserEntity = 
				discountUserService.findById(id).orElseThrow(() -> new DiscountUserException("Discount User is does not have with this id: "+id));

		discountUserEntity.setStatus("InActive");

		DiscountUserEntity deleteDiscountUserO = discountUserService.save(discountUserEntity);

		return ResponseEntity.ok(deleteDiscountUserO);
	}
}
