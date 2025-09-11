package com.web.phucdn.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.ProductCategoryDto;
import com.web.phucdn.models.ProductCategory;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IProductCategoryService;

@RestController
@RequestMapping("/api/v1/productCategory")
public class ProductCategoryController
		extends BaseController<ProductCategory, ProductCategoryDto, IProductCategoryService> {

	public ProductCategoryController(BaseService<ProductCategory, ProductCategoryDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
