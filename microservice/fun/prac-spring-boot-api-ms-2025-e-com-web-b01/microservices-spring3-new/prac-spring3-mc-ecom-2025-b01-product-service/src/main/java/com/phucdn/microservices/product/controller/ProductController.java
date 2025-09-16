package com.phucdn.microservices.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.microservices.product.dto.ProductRequest;
import com.phucdn.microservices.product.dto.ProductResponse;
import com.phucdn.microservices.product.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	private final IProductService productService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return productService.getAllProducts();
	}
}
