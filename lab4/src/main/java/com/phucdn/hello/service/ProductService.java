package com.phucdn.hello.service;

import java.util.List;

import com.phucdn.hello.model.Product;

public interface ProductService {

	void update(Product product);

	List<Product> findAll();

	void remove(int productID);

	void add(Product product);

	Product findByID(int productID);
	
}
