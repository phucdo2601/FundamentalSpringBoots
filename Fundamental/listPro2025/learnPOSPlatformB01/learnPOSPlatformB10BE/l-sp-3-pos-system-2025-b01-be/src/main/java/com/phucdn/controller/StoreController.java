package com.phucdn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.domain.StoreStatus;
import com.phucdn.exceptions.UserException;
import com.phucdn.mapper.StoreMapper;
import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.payload.dto.StoreDto;
import com.phucdn.payload.response.ApiResponse;
import com.phucdn.service.StoreService;
import com.phucdn.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

	private final StoreService storeService;
	private final UserService userService;

	@PostMapping
	public ResponseEntity<StoreDto> createStore(@RequestBody StoreDto storeDto,
			@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.getUserFromJwtToken(jwt);
		return ResponseEntity.ok(storeService.createStore(storeDto, user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StoreDto> getStoreById(@PathVariable("id") Long id,
			@RequestHeader("Authorization") String jwt) throws Exception {
		return ResponseEntity.ok(storeService.getStoreById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<StoreDto>> getAllStores(@RequestHeader("Authorization") String jwt) throws Exception {
		return ResponseEntity.ok(storeService.getAllStores());
	}
	
	
	@GetMapping("/admin")
	public ResponseEntity<StoreDto> getStoreByAdmin(@RequestHeader("Authorization") String jwt) throws Exception {
		return ResponseEntity.ok(StoreMapper.toDto(storeService.getStoreByAdmin()));
	}
	
	@GetMapping("/employee")
	public ResponseEntity<StoreDto> getStoreByEmployee(@RequestHeader("Authorization") String jwt) throws Exception {
		return ResponseEntity.ok(storeService.getStoreByEmployee());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StoreDto> updateStore(@PathVariable("id") Long id, @RequestBody StoreDto storeDto) throws Exception {
		return ResponseEntity.ok(storeService.updateStore(id, storeDto));
	}
	
	@PutMapping("/{id}/moderate")
	public ResponseEntity<StoreDto> moderateStore(@PathVariable("id") Long id, 
			@RequestParam StoreStatus status) throws Exception {
		return ResponseEntity.ok(storeService.moderateStore(id, status));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteStore(@PathVariable Long id) throws Exception {
		storeService.deleteStore(id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Store delete successfully!");
		return ResponseEntity.ok(apiResponse);
	}
}
