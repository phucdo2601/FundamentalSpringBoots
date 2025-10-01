package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.mapper.ProductMapper;
import com.phucdn.model.Product;
import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.payload.dto.ProductDto;
import com.phucdn.repository.ProductRepository;
import com.phucdn.repository.StoreRepository;
import com.phucdn.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public ProductDto createProduct(ProductDto productDto, User user) throws Exception {
		Store store = storeRepository.findById(productDto.getStoreId()).orElseThrow(() -> new Exception("Store not found."));
		
		Product product = ProductMapper.toEntity(productDto, store);
		
		Product savedProduct = productRepository.save(product);
		
		return ProductMapper.toDto(savedProduct);
	}

	@Override
	public ProductDto updateProduct(Long id, ProductDto productDto, User user) throws Exception {
		Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found!"));
		
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setSku(productDto.getSku());
		product.setImage(productDto.getImage());
		product.setMrp(productDto.getMrp());
		product.setSellingPrice(productDto.getSellingPrice());
		product.setBrand(productDto.getBrand());
		product.setUpdatedAt(LocalDateTime.now());
		
		Product savedProduct = productRepository.save(product);
		
		return ProductMapper.toDto(savedProduct);
	}

	@Override
	public void deleteProduct(Long id, User user) throws Exception {
		Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found!"));
		
		productRepository.delete(product);
	}

	@Override
	public List<ProductDto> getProductsByStoreId(Long storeId) {
		List<Product> products = productRepository.findByStoreId(storeId);
		
		return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> searchByKeyword(Long storeId, String keyword) {
		List<Product> products = productRepository.searchByKeyword(storeId, keyword);
		
		return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
	}

}
