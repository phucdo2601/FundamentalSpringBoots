package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductBrandDto;
import com.example.demo.models.ProductBrand;
import com.example.demo.services.BaseService;
import com.example.demo.services.IProductBrandService;

@RestController
@RequestMapping("/api/v1/productBrand")
public class ProductBrandController extends BaseController<ProductBrand, ProductBrandDto, IProductBrandService> {

	@Autowired
	private IProductBrandService iProductBrandService;

	public ProductBrandController(BaseService<ProductBrand, ProductBrandDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

//	@RequestMapping(path = "/uploadData", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<?> addProductBrandFromExcelFile(@RequestParam("file") MultipartFile file) {
//		List<ProductBrand> listProductBrands = new ArrayList<>();
//		String message = "";
//		if (ExcelHelper.hasExcelFormat(file)) {
//			try {
//				listProductBrands = iProductBrandService.saveProductBrandFromExcel(file);
//
//				return ResponseEntity.status(HttpStatus.OK).body(listProductBrands);
//			} catch (Exception e) {
//				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ErrorMessage(message));
//			}
//		}
//
//		message = "Please upload an excel file";
//		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ErrorMessage(message));
//	}
}
