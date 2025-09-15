package com.phucdn.microservices.product.service;

import java.util.List;

import com.phucdn.microservices.product.dto.ProductRequest;
import com.phucdn.microservices.product.dto.ProductResponse;

public interface IProductService {
	void createProduct(ProductRequest productRequest);
	
	List<ProductResponse> getAllProducts();
}
