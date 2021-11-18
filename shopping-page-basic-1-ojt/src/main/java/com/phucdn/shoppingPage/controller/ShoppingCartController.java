package com.phucdn.shoppingPage.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phucdn.shoppingPage.dto.CartItemDTO;
import com.phucdn.shoppingPage.entity.ItemEntity;
import com.phucdn.shoppingPage.repository.DiscountRepository;
import com.phucdn.shoppingPage.service.ItemService;
import com.phucdn.shoppingPage.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private ItemService itemService;

	private ItemEntity itemEntity;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private DiscountRepository discountRepository;

	@RequestMapping(value = "/api/v1/customer/shoppingCart/views", method = RequestMethod.GET)
	public String viewCart(Model model) {
		double subTotal = shoppingCartService.getAmount();
		double vat = shoppingCartService.getAmount() * 0.1;
		double shippingFee = shoppingCartService.getAmount() * 0.05;
		double total = subTotal + vat + shippingFee;
		System.out.println("Quantity of product in cart: " + shoppingCartService.count());
		model.addAttribute("quanInCart", shoppingCartService.count());
		model.addAttribute("cartItem", shoppingCartService.getAllItems());
		model.addAttribute("subTotal", subTotal);
		model.addAttribute("vat", vat);
		model.addAttribute("shippingFee", shippingFee);
		model.addAttribute("total", total);
		String userNameLogin = (String) session.getAttribute("userLoginned");
		System.out.println("User of Cart: "+userNameLogin);
		if (userNameLogin != null) {
			model.addAttribute("listDiscountByUserId", discountRepository.getDiscountByUserId(userNameLogin));
		}
		return "cart";
	}

	@RequestMapping(value = "/api/v1/customer/shoppingCart/add/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") String itemId) {
		System.out.println("Item Id: " + itemId);
		Optional<ItemEntity> itemEntity = itemService.findById(itemId);
		if (itemEntity != null) {
			CartItemDTO cartItem = new CartItemDTO();
			cartItem.setItemId(itemEntity.get().getItemId());
			cartItem.setItemName(itemEntity.get().getItemName());
			cartItem.setImage(itemEntity.get().getImgUrl());
			cartItem.setPrice(itemEntity.get().getPrice());
			cartItem.setQuantity(1);
			shoppingCartService.addCartItem(cartItem);
		}
		return "redirect:/api/v1/customer/shoppingCart/views";
	}

	@RequestMapping(value = "/api/v1/customer/shoppingCart/clearCart", method = RequestMethod.GET)
	public String clearCart() {
		shoppingCartService.clear();
		return "redirect:/api/v1/customer/shoppingCart/views";
	}

	@RequestMapping(value = "/api/v1/customer/shoppingCart/del/{id}", method = RequestMethod.GET)
	public String removeItemInCartById(@PathVariable("id") String id) {
		shoppingCartService.remove(id);
		return "redirect:/api/v1/customer/shoppingCart/views";
	}

	@RequestMapping(value = "/api/v1/customer/shoppingCart/upQuan/{id}")
	public String increaseOneQuanByItemId(@PathVariable("id") String itemId) {
		
		shoppingCartService.increaseOneQuanById(itemId);

		return "redirect:/api/v1/customer/shoppingCart/views";
	}

	@RequestMapping(value = "/api/v1/customer/shoppingCart/downQuan/{id}")
	public String decreaseOneQuanByItemId(@PathVariable("id") String itemId) {
		shoppingCartService.decreaseOneQuanById(itemId);
		return "redirect:/api/v1/customer/shoppingCart/views";
	}
}
