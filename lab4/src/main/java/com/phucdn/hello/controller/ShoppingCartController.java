package com.phucdn.hello.controller;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phucdn.hello.model.CartObj;
import com.phucdn.hello.model.Product;
import com.phucdn.hello.service.ProductService;
import com.phucdn.hello.service.ShoppingCartService;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
	@Autowired
	ProductService productService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@GetMapping("list")
	public String list(Model model) {
		Collection<CartObj> cartObj = shoppingCartService.getCartItems();
		
		model.addAttribute("cartItems", cartObj);
		model.addAttribute("total", shoppingCartService.getAmount());
		model.addAttribute("NoOfItems", shoppingCartService.getCount());
		
		return "shoppingCarts/list";
	}
	
	@GetMapping("add/{productID}")
	public String add(@PathVariable("productID") Integer productID) {
		Product product = productService.findByID(productID);
		if (product != null) {
			CartObj item = new CartObj();
			BeanUtils.copyProperties(product, item);//su dung ky thuat BeanUtils cho phep copy noi dung tu product sang item
			/*
			 * Su dung phuong thuc copyProperties giup chung ta tiep kiem thoi gian viet ma de chuyen cac phuong thuc cua product
			 * */
			item.setQuantity(1);
			shoppingCartService.add(item);
					
		}
		
		return "redirect:/shoppingCart/list";
	}
	
	@GetMapping("remove/{productID}")
	public String remove(@PathVariable("productID") Integer productID) {
		shoppingCartService.remove(productID);
		
		
		return "redirect:/shoppingCart/list";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("productID") Integer productID,
			@RequestParam("quantity") Integer quantity) {
		shoppingCartService.update(productID, quantity);
		return "redirect:/shoppingCart/list";
	}
	
	@GetMapping("clear")
	public String clear() {
		return "redirect:/shoppingCart/list";
	}
}
