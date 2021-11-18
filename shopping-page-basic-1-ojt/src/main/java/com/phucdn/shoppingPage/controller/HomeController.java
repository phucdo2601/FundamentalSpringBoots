package com.phucdn.shoppingPage.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.phucdn.shoppingPage.dto.UserDTO;
import com.phucdn.shoppingPage.entity.ItemEntity;
import com.phucdn.shoppingPage.entity.RoleUserEntity;
import com.phucdn.shoppingPage.entity.UserEntity;
import com.phucdn.shoppingPage.repository.ItemRepository;
import com.phucdn.shoppingPage.service.CategoryService;
import com.phucdn.shoppingPage.service.ItemService;
import com.phucdn.shoppingPage.service.RoleUserService;
import com.phucdn.shoppingPage.service.ShoppingCartService;
import com.phucdn.shoppingPage.service.UserService;
import com.phucdn.shoppingPage.utils.EncrytedPasswordUtils;

@Controller
@RequestMapping("/api/v1/customer")
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RoleUserService roleUserService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping()
	public String loadListProductsHomePage(Model model) {
		model.addAttribute("listAllProducts", itemService.findAll());
		model.addAttribute("listCategory", categoryService.findAll());
		model.addAttribute("quanInCart", shoppingCartService.count());
		model.addAttribute("lastItem", itemRepository.getLastItem());
		return "homePage";
	}
	
	@GetMapping("/cart")
	public String loadCartPage() {
		return "cart";
	}
	
	@GetMapping("/signUp")
	public String loadSignupPage(Model model) {
		model.addAttribute("user", new UserDTO());
		model.addAttribute("roleUser", roleUserService.findAll());
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String registerNewUser(@ModelAttribute("user") UserDTO userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setStatus("Active");
		RoleUserEntity roleUserEntity = new RoleUserEntity();
		roleUserEntity.setRoleId("user");
		userEntity.setRoleUser(roleUserEntity);
		String realPass = EncrytedPasswordUtils.encrytePassword(userDto.getPassword());
		userEntity.setPassword(realPass);
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		userEntity.setDateOfCreate(dateOfCreate);
		userService.save(userEntity);
		
		return "redirect:/api/v1/customer";
		
	}
	
	@GetMapping("/itemsByCateId/{cateId}")
	public String loadItemsByyCateId(@PathVariable("cateId") String cateId, Model model) {
		List<ItemEntity> listItemsByCateId = itemRepository.loadItemsByCateId(cateId);
		model.addAttribute("listItemsByCateId", listItemsByCateId);
		model.addAttribute("listCategory", categoryService.findAll());
		model.addAttribute("quanInCart", shoppingCartService.count());
		return "homePage";
	}
	
	@GetMapping("/viewDe/{itemId}/category")
	public String viewProductDetail(@PathVariable("itemId") String itemId,
			@RequestParam("cateId") String cateId,
			Model model) {
		Optional<ItemEntity> getItemById = itemService.findById(itemId);
		System.out.println(getItemById.get().getImgUrl());
		model.addAttribute("itemDetail", itemService.findById(itemId));
		model.addAttribute("listCategory", categoryService.findAll());
		model.addAttribute("listRecommmenItems", itemRepository.loadRecommendItemsByCateId(cateId));
		model.addAttribute("lastItem", itemRepository.getLastItem());
		return "productDetails";
	}
	
	@GetMapping("/searchByItemId")
	public String searchItemById(ModelMap model, @RequestParam(name = "itemSearch", required = false) String itemId) {
		List<ItemEntity> listAResult = itemRepository.searchItemLikeByItemId(itemId);
		model.addAttribute("listItemByItemId", listAResult);
		model.addAttribute("listCategory", categoryService.findAll());
		model.addAttribute("quanInCart", shoppingCartService.count());
		return "homePage";
	}
}
