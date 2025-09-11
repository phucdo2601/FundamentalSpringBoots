package com.phucdn.productservice.service;

import java.util.List;

import com.phucdn.productservice.dto.ProductRequest;
import com.phucdn.productservice.dto.ProductResponse;

public interface IProductService {
	void createProduct(ProductRequest productRequest);
	List<ProductResponse> getAllProducts();
}
