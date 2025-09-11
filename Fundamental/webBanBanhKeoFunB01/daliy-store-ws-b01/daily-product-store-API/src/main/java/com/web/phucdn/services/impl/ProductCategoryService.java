package com.web.phucdn.services.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.ProductCategoryDto;
import com.web.phucdn.models.ProductCategory;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.ProductCategoryRepository;
import com.web.phucdn.services.IProductCategoryService;

@Service
public class ProductCategoryService implements IProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public BaseRepository<ProductCategory> getRepository() {

		return productCategoryRepository;
	}

	@Override
	public ProductCategoryDto convertEntityToDto(ProductCategory t) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		ProductCategoryDto productCategoryDto = new ProductCategoryDto();
		productCategoryDto = modelMapper.map(t, ProductCategoryDto.class);
		return productCategoryDto;
	}

	@Override
	public ProductCategory convertDtoToEntity(ProductCategoryDto c) {
		// set up for model mapper for adapt number
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		String statusId = c.getStatusId();
		try {
			UUID statusIdUUID = UUID.fromString(statusId);
			ProductCategory productCategory = new ProductCategory();
			productCategory = modelMapper.map(c, ProductCategory.class);
			return productCategory;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("The field with UUID type does not valid!");
		}

	}

}
