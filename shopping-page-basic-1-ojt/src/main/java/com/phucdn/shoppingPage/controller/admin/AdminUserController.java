package com.phucdn.shoppingPage.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phucdn.shoppingPage.entity.Category;
import com.phucdn.shoppingPage.entity.UserEntity;
import com.phucdn.shoppingPage.repository.UserRepository;
import com.phucdn.shoppingPage.service.UserService;

@Controller
@RequestMapping("/api/v1/admin/users")
public class AdminUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping()
	public String loadUsersOnUserPage(Model model) {
		model.addAttribute("listUser", userService.findAll());
		return "admin/users/user";
	}
	
	@GetMapping("/searchById")
	public String searchCategoryById(ModelMap model, @RequestParam(name = "userSearch", required = false) String userId) {
		List<UserEntity> listAResult = userRepository.searchUserLikeByUserId(userId);
		model.addAttribute("aListSearchUser", listAResult);
		
		return "admin/users/user";
	}
}
