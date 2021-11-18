package com.phucdn.shoppingPage.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.shoppingPage.dto.ItemDTO;
import com.phucdn.shoppingPage.entity.Category;
import com.phucdn.shoppingPage.entity.DiscountEntity;
import com.phucdn.shoppingPage.entity.ItemEntity;
import com.phucdn.shoppingPage.repository.ItemRepository;
import com.phucdn.shoppingPage.service.CategoryService;
import com.phucdn.shoppingPage.service.ItemService;
import com.phucdn.shoppingPage.utils.FileUploadUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/api/v1/admin/items")
public class AdminItemController {
	
	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping()
	public String loadItemOnUserPage(Model model) {
		model.addAttribute("listCate", categoryService.findAll());
		model.addAttribute("listItem", itemService.findAll());
		return "admin/items/item";
	}
	
	@GetMapping("/addNewItem")
	public String addNewItem(Model model) {
		model.addAttribute("listCate", categoryService.findAll());
		model.addAttribute("item", new ItemDTO());
		return "admin/items/addNewItem";
	}
	
	@PostMapping("/saveItem")
	public ModelAndView addNewItem(ModelMap model,
			@RequestParam("imgUrl") MultipartFile multipartFile,
			 @ModelAttribute("item") ItemDTO itemDto,
			BindingResult result) throws IOException {
		System.out.println(multipartFile);
//		if (result.hasErrors()) {
//			return new ModelAndView("admin/items/addNewItem");
//		}
		ItemEntity entity = new ItemEntity();
		BeanUtils.copyProperties(itemDto, entity);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "uploads/";
		System.out.println(fileName);
		FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);
		entity.setImgUrl(fileName);
		Category category = new Category();
		category.setCateId(itemDto.getCateId());
		entity.setCategory(category);
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		entity.setDateOfCreate(dateOfCreate);
		entity.setStatus("Active");
		itemService.save(entity);
		
		model.addAttribute("message", "Product is saved!");
		
		return new ModelAndView("redirect:/api/v1/admin/items", model);
		
	}
	
//	@PostMapping("/saveItem")
//	public String saveNewItem(@ModelAttribute("item")ItemDTO itemDto) {
//		ItemEntity entity = new ItemEntity();
//		BeanUtils.copyProperties(itemDto, entity);
//		
//		Category category = new Category();
//		category.setCateId(itemDto.getCateId());
//		entity.setCategory(category);
//		Long mills = System.currentTimeMillis();
//		Date dateOfCreate = new Date(mills);
//		entity.setDateOfCreate(dateOfCreate);
//		entity.setStatus("Active");
//		
//		itemService.save(entity);
//		
//		return "redirect:/api/v1/admin/items";
//	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditItemPage(@PathVariable("id") String itemId) {
		ModelAndView mav = new ModelAndView("admin/items/updateItem");
		ItemEntity itemEntity = itemService.getById(itemId);
		ItemDTO itemDTO = new ItemDTO();
		String categoryId = itemEntity.getCategory().getCateId();
		BeanUtils.copyProperties(itemEntity, itemDTO);
		itemDTO.setCateId(categoryId);
		mav.addObject("item", itemDTO);
		mav.addObject("listCate", categoryService.findAll());
		return mav;
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") String itemId) {
		String status = "InActive";
		System.out.println(itemId);
		itemRepository.updateItemStatusByItemId(status, itemId);
		
		return "redirect:/api/v1/admin/items";
	}
	
	@PostMapping("/updateItem")
	public String uploadItemById(@ModelAttribute("item") ItemDTO itemDto) {
		String itemId = itemDto.getItemId();
		String itemName = itemDto.getItemName();
		String cateId = itemDto.getCateId();
		String author = itemDto.getAuthor();
		double price = itemDto.getPrice();
		int quantity = itemDto.getQuantity();
		String description = itemDto.getDescription();
		
		itemRepository.updateItemByItemId(itemId, itemName, cateId, author, price, quantity, description);
		
		return "redirect:/api/v1/admin/items/";
	}
	
	@GetMapping("/searchById")
	public String searchItemById(ModelMap model, @RequestParam(name = "itemSearch", required = false) String itemId) {
		List<ItemEntity> listAResult = itemRepository.searchItemLikeByItemId(itemId);
		model.addAttribute("aListSearchItem", listAResult);
		
		return "admin/items/item";
	}
}
