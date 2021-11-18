package com.phucdn.shoppingPage.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phucdn.shoppingPage.service.UserService;
import com.phucdn.shoppingPage.utils.WebUtils;


@Controller
public class LoginController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/v1/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/api/v1/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if (principal != null) {
			User loginnedUser = (User) ((Authentication) principal).getPrincipal();
			
			String userInfo = WebUtils.toString(loginnedUser);
			
			model.addAttribute("userInfo", userInfo);
			
			String message = "Hi " + principal.getName() //
			+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);
		}
		
		return "403Page";
	}
	
	@RequestMapping(value = "/api/v1/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi login thanh cong se co principal
		String userName = principal.getName();
		System.out.println("Username: " + userName);

		User loginnedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = com.phucdn.shoppingPage.utils.WebUtils.toString2(loginnedUser);

		System.out.println("UserInfo is loginned: "+loginnedUser.getUsername());
		String userLoginned = loginnedUser.getUsername();
		model.addAttribute("userInfo", userInfo);
		session.setAttribute("userLoginned", userLoginned);
		session.setAttribute("userLogSession", userService.findById(userLoginned));
		return "userInfoPage";
	}
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		return "redirect:/api/v1/customer";
	}
}
