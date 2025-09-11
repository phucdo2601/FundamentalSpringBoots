package com.example.demo.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductBrandDto;
import com.example.demo.models.ProductBrand;

public interface IProductBrandService extends BaseService<ProductBrand, ProductBrandDto> {
	public List<ProductBrand> saveProductBrandFromExcel(MultipartFile file);
}
