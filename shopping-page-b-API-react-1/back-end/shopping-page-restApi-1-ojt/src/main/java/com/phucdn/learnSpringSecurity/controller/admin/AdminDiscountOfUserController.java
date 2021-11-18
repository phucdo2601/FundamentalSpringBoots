package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.ArrayList;
import java.util.Date;
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

import com.phucdn.learnSpringSecurity.dto.DiscountOfUserDTO;
import com.phucdn.learnSpringSecurity.entity.DiscountOfUserEntity;
import com.phucdn.learnSpringSecurity.exception.DiscountOfUserException;
import com.phucdn.learnSpringSecurity.repository.DiscountOfUserRepository;
import com.phucdn.learnSpringSecurity.service.DiscountOfUserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/discountOfUser")
public class AdminDiscountOfUserController {
	
	@Autowired
	private DiscountOfUserService discountOfUserService;
	
	@Autowired
	private DiscountOfUserRepository discountOfUserRepository;
	
	@GetMapping("")
	public List<DiscountOfUserEntity> loadAllDiscountOfUser() {
		
		return discountOfUserService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiscountOfUserEntity> getDiscountOfUserById(@PathVariable("id") String discountId) {
		DiscountOfUserEntity discountOfUserEntity = 
				discountOfUserService.findById(discountId).orElseThrow(() -> new DiscountOfUserException("Discount of user is not existed with id: "+discountId));
		
		return ResponseEntity.ok(discountOfUserEntity);				
	}
	
	@PostMapping("")
	public DiscountOfUserEntity createNewDiscount(@RequestBody DiscountOfUserEntity discountOfUser) {
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		discountOfUser.setDateOfCreate(dateOfCreate);
		discountOfUser.setStatus("Active");
		
		return discountOfUserService.save(discountOfUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DiscountOfUserEntity> updateDiscountById(@PathVariable("id") String discountId, @RequestBody DiscountOfUserEntity discountOfUser) {
		DiscountOfUserEntity discountOfUserEntity = 
				discountOfUserService.findById(discountId).orElseThrow(() -> new DiscountOfUserException("Discount of user is not existed with id: "+discountId));
		
		discountOfUserEntity.setDiscountName(discountOfUser.getDiscountName());
		discountOfUserEntity.setDescription(discountOfUser.getDescription());
		discountOfUserEntity.setRateDis(discountOfUser.getRateDis());
		Long mills = System.currentTimeMillis();
		Date dateOfUpdate = new Date(mills);
		discountOfUserEntity.setDateOfCreate(dateOfUpdate);
		discountOfUserEntity.setStatus("Active");
		
		DiscountOfUserEntity discountUpdate = discountOfUserService.save(discountOfUserEntity);
		
		return ResponseEntity.ok(discountUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDiscount(@PathVariable("id") String discountId) {
		DiscountOfUserEntity discountOfUserEntity = 
				discountOfUserService.findById(discountId).orElseThrow(() -> new DiscountOfUserException("Discount of user is not existed with id: "+discountId));
		
		discountOfUserService.delete(discountOfUserEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/delO/{id}")
	public ResponseEntity<DiscountOfUserEntity> deleteDiscountOfUserOriginal(@PathVariable("id") String discountId) {
		DiscountOfUserEntity discountOfUserEntity = 
				discountOfUserService.findById(discountId).orElseThrow(() -> new DiscountOfUserException("Discount of user is not existed with id: "+discountId));
		
		discountOfUserEntity.setStatus("InActive");
		
		DiscountOfUserEntity deleteRoleOfUserO = discountOfUserService.save(discountOfUserEntity);
		
		return ResponseEntity.ok(deleteRoleOfUserO);
	}
	
	@PutMapping("/reActO/{id}")
	public ResponseEntity<DiscountOfUserEntity> reActivateDiscountByDiscountId(@PathVariable("id") String discountId) {
		DiscountOfUserEntity discountOfUserEntity = 
				discountOfUserService.findById(discountId).orElseThrow(() -> new DiscountOfUserException("Discount of user is not existed with id: "+discountId));
		
		
		discountOfUserEntity.setStatus("Active");
		
		DiscountOfUserEntity reActivateDiscount = discountOfUserService.save(discountOfUserEntity);
		
		return ResponseEntity.ok(reActivateDiscount);
	}
}
