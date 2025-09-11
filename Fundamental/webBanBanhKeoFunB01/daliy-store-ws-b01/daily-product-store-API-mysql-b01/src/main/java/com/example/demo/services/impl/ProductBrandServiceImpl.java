package com.example.demo.services.impl;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductBrandDto;
import com.example.demo.helper.ExcelHelper;
import com.example.demo.models.ProductBrand;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.ProductBrandRepository;
import com.example.demo.services.IProductBrandService;

@Service
public class ProductBrandServiceImpl implements IProductBrandService {

	@Autowired
	private ProductBrandRepository productBrandRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseRepository<ProductBrand> getRepository() {
		// TODO Auto-generated method stub
		return productBrandRepository;
	}

	@Override
	public ProductBrandDto convertEntityToDto(ProductBrand t) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		ProductBrandDto productBrandDto = new ProductBrandDto();
		productBrandDto = modelMapper.map(t, ProductBrandDto.class);
		return productBrandDto;
	}

	@Override
	public ProductBrand convertDtoToEntity(ProductBrandDto c) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		ProductBrand productBrand = new ProductBrand();
		productBrand = modelMapper.map(c, ProductBrand.class);
		return productBrand;
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
