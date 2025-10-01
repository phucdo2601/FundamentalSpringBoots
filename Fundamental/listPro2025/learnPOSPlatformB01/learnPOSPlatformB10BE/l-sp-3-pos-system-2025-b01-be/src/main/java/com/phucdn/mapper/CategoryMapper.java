package com.phucdn.mapper;

import com.phucdn.model.Category;
import com.phucdn.payload.dto.CategoryDto;

public class CategoryMapper {
	public static CategoryDto toDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.name(category.getName())
				.storeId(category.getStore() != null ? category.getStore().getId() : null)
				.build();
	}
}
