package com.web.phucdn.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.phucdn.dto.ProductBrandDto;
import com.web.phucdn.helper.ExcelHelper;
import com.web.phucdn.models.ProductBrand;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.ProductBrandRepository;
import com.web.phucdn.services.IProductBrandService;

@Service
public class ProductBrandServiceImpl implements IProductBrandService {

	@Autowired
	private ProductBrandRepository productBrandRepository;

	@Override
	public BaseRepository<ProductBrand> getRepository() {
		// TODO Auto-generated method stub
		return productBrandRepository;
	}

	@Override
	public ProductBrandDto convertEntityToDto(ProductBrand t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductBrand convertDtoToEntity(ProductBrandDto c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBrand> saveProductBrandFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			List<ProductBrand> listDataFromExcelFile = ExcelHelper.excelToProductBrands(file.getInputStream());

			List<ProductBrand> listProductBrand = productBrandRepository.saveAll(listDataFromExcelFile);
			return listProductBrand;
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
