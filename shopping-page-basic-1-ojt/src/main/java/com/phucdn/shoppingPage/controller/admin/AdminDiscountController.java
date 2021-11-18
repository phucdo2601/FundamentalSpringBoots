package com.phucdn.shoppingPage.controller.admin;

import java.text.SimpleDateFormat;
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

import com.phucdn.shoppingPage.dto.DiscountDTO;
import com.phucdn.shoppingPage.entity.Category;
import com.phucdn.shoppingPage.entity.DiscountEntity;
import com.phucdn.shoppingPage.entity.UserEntity;
import com.phucdn.shoppingPage.repository.DiscountRepository;
import com.phucdn.shoppingPage.service.DiscountService;
import com.phucdn.shoppingPage.service.UserService;

@Controller
@RequestMapping("/api/v1/admin/discounts")
public class AdminDiscountController {
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DiscountRepository discountRepository;
	
	@GetMapping()
	public String loadDiscountPage(Model model) {
		List<DiscountEntity> listDis = discountService.findAll();
		
		model.addAttribute("listDiscount", discountService.findAll());
		return "admin/discounts/discount";
	}
	
	@GetMapping("/addNewDiscount")
	public String loadAddDiscountPage(Model model) {
		model.addAttribute("discount", new DiscountDTO());
		model.addAttribute("listUser", userService.findAll());
		return "admin/discounts/addNewDiscount";
	}
	
	@PostMapping("/saveDiscount")
	public String saveDiscount(@ModelAttribute("discount") DiscountDTO discountDto) {
		
		DiscountEntity entity = new DiscountEntity();
		BeanUtils.copyProperties(discountDto, entity);
		UserEntity user = new UserEntity();
		user.setUserId(discountDto.getUserId());
		entity.setUser(user);
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		entity.setDateOfCreate(dateOfCreate);
		entity.setUsing(false);
		
		discountService.save(entity);
		
		return "redirect:/api/v1/admin/discounts";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDiscountById(@PathVariable("id") String discountId) {
		discountRepository.updateDiscountStatusByDiscountId(discountId);
		
		return "redirect:/api/v1/admin/discounts";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editDisountPage(@PathVariable("id") String discountId) {
		ModelAndView mav = new ModelAndView("admin/discounts/updateDiscount");
		DiscountEntity discountEntity = discountService.getById(discountId);
		DiscountDTO discountDTO = new DiscountDTO();
		String userId = discountEntity.getUser().getUserId();
		BeanUtils.copyProperties(discountEntity, discountDTO);
		discountDTO.setUserId(userId);
		
		mav.addObject("discount", discountDTO);
		mav.addObject("listUser", userService.findAll());
		
		return mav;
	}
	
	@PostMapping("/updateDiscount")
	public String updateDiscountByDisId(@ModelAttribute("discount") DiscountDTO discountDTO) {
		String userId = discountDTO.getUserId();
		System.out.println("UserId: "+userId);
		String disId = discountDTO.getDiscountId();
		System.out.println(disId);
		String disName = discountDTO.getDiscountName();
		System.out.println(disName);
		double rateDis = discountDTO.getRateDis();
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		
		discountRepository.updateDiscountByDiscountId(disId, disName, rateDis, dateOfCreate, userId);
		
		return "redirect:/api/v1/admin/discounts";
	}
	
	@GetMapping("/searchById")
	public String searchDiscountById(ModelMap model, @RequestParam(name = "discountSearch", required = false) String discountId) {
		List<DiscountEntity> listAResult = discountRepository.searchDiscountLikeByDisId(discountId);
		model.addAttribute("aListSearchDiscount", listAResult);
		
		return "admin/discounts/discount";
	}
}
