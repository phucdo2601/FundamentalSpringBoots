package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct (Product p) {
		return productRepository.save(p);
	}
	
	public List<Product> saveProducts (List<Product> listProduct) {
		return productRepository.saveAll(listProduct);
	}
	
	public List<Product> getListProduct() {
		return productRepository.findAll();
	}
	
	public Product getProductById (int id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product getProductByName (String name) {
		return productRepository.findByName(name);
	}

	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Product removed !!" +id;
	}
	
	public Product updateProduct(Product p) {
		Product existingProduct = productRepository.findById(p.getId()).orElse(null);
		existingProduct.setName(p.getName());
		existingProduct.setPrice(p.getPrice());
		existingProduct.setQuantity(p.getQuantity());
		return productRepository.save(existingProduct);
		
	}
}
