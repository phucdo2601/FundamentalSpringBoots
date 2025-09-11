package com.web.phucdn.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.phucdn.dto.ErrorMessage;
import com.web.phucdn.dto.ProductBrandDto;
import com.web.phucdn.helper.ExcelHelper;
import com.web.phucdn.models.ProductBrand;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IProductBrandService;

@RestController
@RequestMapping("/api/v1/productBrand")
public class ProductBrandController extends BaseController<ProductBrand, ProductBrandDto, IProductBrandService> {

	@Autowired
	private IProductBrandService iProductBrandService;

	public ProductBrandController(BaseService<ProductBrand, ProductBrandDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(path = "/uploadData", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addProductBrandFromExcelFile(@RequestParam("file") MultipartFile file) {
		List<ProductBrand> listProductBrands = new ArrayList<>();
		String message = "";
		if (ExcelHelper.hasExcelFormat(file)) {
			try {
				listProductBrands = iProductBrandService.saveProductBrandFromExcel(file);

				return ResponseEntity.status(HttpStatus.OK).body(listProductBrands);
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ErrorMessage(message));
			}
		}

		message = "Please upload an excel file";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ErrorMessage(message));
	}
}
