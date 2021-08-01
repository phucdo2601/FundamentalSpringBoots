package com.phucdn.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phucdn.hello.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;//su dung in-getch cua spring cho phep tim cac doi tuong cua ProductService
	//vao bien productService
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products/list";
	}
}
