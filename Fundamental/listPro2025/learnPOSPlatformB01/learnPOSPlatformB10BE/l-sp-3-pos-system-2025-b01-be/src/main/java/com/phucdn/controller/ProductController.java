package com.phucdn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.exceptions.UserException;
import com.phucdn.model.User;
import com.phucdn.payload.dto.ProductDto;
import com.phucdn.payload.response.ApiResponse;
import com.phucdn.service.ProductService;
import com.phucdn.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto,
			@RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.getUserFromJwtToken(jwt);
		
		return ResponseEntity.ok(productService.createProduct(productDto, user));
	}
	
	@GetMapping("/store/{storeId}")
	public ResponseEntity<List<ProductDto>> getByStoreId(@PathVariable("storeId") Long storeId,
			@RequestHeader("Authorization") String jwt) throws UserException {
		return ResponseEntity.ok(productService.getProductsByStoreId(storeId));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable("id") Long id,@RequestBody ProductDto productDto, @RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.getUserFromJwtToken(jwt);
		
		return ResponseEntity.ok(productService.updateProduct(id, productDto, user));
	}
	
	@GetMapping("/store/{storeId}/search")
	public ResponseEntity<List<ProductDto>> searchByKeyword(@PathVariable("storeId") Long storeId,
			@RequestParam String keyword,
			@RequestHeader("Authorization") String jwt) throws UserException {
		return ResponseEntity.ok(productService.searchByKeyword(storeId, keyword));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id, @RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.getUserFromJwtToken(jwt);
		productService.deleteProduct(id, user);
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Delete Product successfully!");
		
		return ResponseEntity.ok(apiResponse);
	}
}

