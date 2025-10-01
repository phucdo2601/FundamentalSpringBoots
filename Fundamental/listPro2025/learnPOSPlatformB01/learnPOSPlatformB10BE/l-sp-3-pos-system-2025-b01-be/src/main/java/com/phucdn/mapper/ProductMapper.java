package com.phucdn.mapper;

import com.phucdn.model.Category;
import com.phucdn.model.Product;
import com.phucdn.model.Store;
import com.phucdn.payload.dto.ProductDto;

public class ProductMapper {

	public static ProductDto toDto(Product product) {
		return ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.sku(product.getSku())
				.description(product.getDescription())
				.mrp(product.getMrp())
				.sellingPrice(product.getSellingPrice())
				.brand(product.getBrand())
				.category(CategoryMapper.toDto(product.getCategory()))
				.storeId(product.getStore() != null ? product.getStore().getId() : null)
				.image(product.getImage())
				.createdAt(product.getCreatedAt())
				.updatedAt(product.getUpdatedAt())
				.build();
//		.categoryId(pro)
	}
	
	public static Product toEntity(ProductDto productDto, Store store, Category category) {
		return Product.builder()
				.name(productDto.getName())
				.store(store)
				.category(category)
				.sku(productDto.getSku())
				.description(productDto.getDescription())
				.mrp(productDto.getMrp())
				.sellingPrice(productDto.getSellingPrice())
				.brand(productDto.getBrand())
				.build();
//		.categoryId(pro)
	}
}
