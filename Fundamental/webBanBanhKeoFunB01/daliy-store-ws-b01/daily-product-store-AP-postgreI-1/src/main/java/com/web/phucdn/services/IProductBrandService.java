package com.web.phucdn.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.phucdn.dto.ProductBrandDto;
import com.web.phucdn.models.ProductBrand;

public interface IProductBrandService extends BaseService<ProductBrand, ProductBrandDto> {
	public List<ProductBrand> saveProductBrandFromExcel(MultipartFile file);
}
