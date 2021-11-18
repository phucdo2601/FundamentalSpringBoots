package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.entity.CategoryEntity;
import com.phucdn.learnSpringSecurity.exception.CategoryException;
import com.phucdn.learnSpringSecurity.repository.CategoryRepository;
import com.phucdn.learnSpringSecurity.service.CategoryService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/categories")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("")
	public List<CategoryEntity> loadAllCategory() {
		return categoryRepository.findAllCategoryWithActiveStatus();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable("id") String cateId) {
		CategoryEntity categoryEntity = 
				categoryService.findById(cateId).orElseThrow(() -> new CategoryException("Category is not exsited with this id "+cateId));
		
		return ResponseEntity.ok(categoryEntity);
	}
	
	@PostMapping("")
	public CategoryEntity addNewCategory(@RequestBody CategoryEntity categoryEntity) {
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		categoryEntity.setDateOfCreate(dateOfCreate);
		categoryEntity.setStatus("Active");
		
		return categoryService.save(categoryEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryEntity> updateCategoryById(@PathVariable("id") String cateId, @RequestBody CategoryEntity category) {
		CategoryEntity categoryEntity = 
				categoryService.findById(cateId).orElseThrow(() -> new CategoryException("Category is not exsited with this id "+cateId));
		
		categoryEntity.setCateName(category.getCateName());
		categoryEntity.setDescription(category.getDescription());
		Long mills = System.currentTimeMillis();
		Date dateOfUpdate = new Date(mills);
		categoryEntity.setDateOfCreate(dateOfUpdate);
		CategoryEntity updateCategory = categoryService.save(categoryEntity);
		
		return ResponseEntity.ok(updateCategory);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCategoryById(@PathVariable("id") String cateId) {
		CategoryEntity categoryEntity = 
				categoryService.findById(cateId).orElseThrow(() -> new CategoryException("Category is not exsited with this id "+cateId));
		
		categoryService.delete(categoryEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/delO/{id}")
	public ResponseEntity<CategoryEntity> deleteCategoryOriginal(@PathVariable("id") String cateId) {
		CategoryEntity categoryEntity = 
				categoryService.findById(cateId).orElseThrow(() -> new CategoryException("Category is not exsited with this id "+cateId));
		
		categoryEntity.setStatus("InActive");
		
		CategoryEntity deleteCategoryO = categoryService.save(categoryEntity);
		
		return ResponseEntity.ok(deleteCategoryO);
	}
}
