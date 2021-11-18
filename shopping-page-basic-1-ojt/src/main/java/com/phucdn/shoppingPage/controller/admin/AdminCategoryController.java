package com.phucdn.shoppingPage.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.shoppingPage.dto.CategoryDTO;
import com.phucdn.shoppingPage.entity.BookingEntity;
import com.phucdn.shoppingPage.entity.Category;
import com.phucdn.shoppingPage.repository.CategoryRepository;
import com.phucdn.shoppingPage.service.CategoryService;

@Controller
@RequestMapping("/api/v1/admin/categories")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping()
	public String loadCategoryPage(Model model) {
		model.addAttribute("listCategory", categoryService.findAll());
		return "admin/categories/category";
	}
	
	@GetMapping("/addNewCategory")
	public String loadAddNewCategoryPage(Model model) {
		model.addAttribute("category", new CategoryDTO());
		
		return "admin/categories/addNewCategory";
	}
	
	@PostMapping("/saveCategory")
	public String saveNewCategory(@ModelAttribute("category") CategoryDTO cateDTO) {
		Category entity = new Category();
		BeanUtils.copyProperties(cateDTO, entity);
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		entity.setDateOfCreate(dateOfCreate);
		entity.setStatus(true);
		
		categoryService.save(entity);
		
		return "redirect:/api/v1/admin/categories";
		
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") String cateId) {
		System.out.println(cateId);
		categoryRepository.updateCategoryStatusByCategoryId(cateId);
		
		return "redirect:/api/v1/admin/categories";
		
	}
	
	@GetMapping("/editCategory/{id}")
	public ModelAndView showEditCategoryPage(@PathVariable("id") String cateId) {
		ModelAndView mav = new ModelAndView("admin/categories/updateCategory");
		Category categoryEntity = categoryService.getById(cateId);
		CategoryDTO cateDto = new CategoryDTO();
		BeanUtils.copyProperties(categoryEntity, cateDto);
		mav.addObject("category", cateDto);
		return mav;
	}
	
	@PostMapping("/updateCategory")
	public String updateCategoryByCateId(@ModelAttribute("category") CategoryDTO cateDto) {
		String cateId = cateDto.getCateId();
		String cateName = cateDto.getCateName();
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		categoryRepository.updateCategoryByCategoryId(cateId, cateName, dateOfCreate);
		
		return "redirect:/api/v1/admin/categories";
	}
	
	@GetMapping("/searchById")
	public String searchCategoryById(ModelMap model, @RequestParam(name = "categorySearch", required = false) String cateId) {
		List<Category> listAResult = categoryRepository.searchCategoryLikeByCateId(cateId);
		model.addAttribute("aListSearchCategory", listAResult);
		
		return "admin/categories/category";
	}
}
