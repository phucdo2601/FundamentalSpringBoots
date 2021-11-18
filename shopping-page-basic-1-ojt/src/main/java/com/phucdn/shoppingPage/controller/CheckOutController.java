package com.phucdn.shoppingPage.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phucdn.shoppingPage.dto.CartItemDTO;
import com.phucdn.shoppingPage.entity.BookingDetailEntity;
import com.phucdn.shoppingPage.entity.BookingEntity;
import com.phucdn.shoppingPage.entity.ItemEntity;
import com.phucdn.shoppingPage.entity.UserEntity;
import com.phucdn.shoppingPage.repository.BookingDetailRepository;
import com.phucdn.shoppingPage.repository.BookingRepository;
import com.phucdn.shoppingPage.service.BookingDetailService;
import com.phucdn.shoppingPage.service.BookingService;
import com.phucdn.shoppingPage.service.DiscountService;
import com.phucdn.shoppingPage.service.ShoppingCartService;

@Controller
public class CheckOutController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingDetailRepository bookingDetailRepository;

	@Autowired
	private DiscountService discountService;

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingDetailService bookingDetailService;

	@RequestMapping(value = "/api/v1/customer/checkout", method = RequestMethod.POST)
	public String checkoutByUser(Model model) {
		Collection<CartItemDTO> click = shoppingCartService.getAllItems();
		String txtUserId = request.getParameter("txtUsername");
		String txtCustomerName = request.getParameter("txtCustomerName");
		String txtAddressShipping = request.getParameter("txtAddressShipping");
		String txtPhone = request.getParameter("txtPhone");
		String email = request.getParameter("txtEmail");
		String payMethod = request.getParameter("payMethod");
		
		String txtSubTotal = request.getParameter("txtSubTotal");
		
		String txtShippingFee = request.getParameter("txtShipping");
		String txtVat = request.getParameter("txtTax");
		String txtTotal = request.getParameter("txtTotal");
		System.out.println(txtSubTotal);
		System.out.println(txtShippingFee);
		System.out.println(txtVat);
		System.out.println(txtTotal);
		double subTotal = Double.parseDouble(txtSubTotal);
		
		double shippingFee = Double.parseDouble(txtShippingFee);
		double vat = Double.parseDouble(txtVat);
		double total = Double.parseDouble(txtTotal);
		System.out.println("UserId: "+txtUserId);
		System.out.println("CustomerName: "+txtCustomerName);
		System.out.println("AddressShipping: "+txtAddressShipping);
		System.out.println("Phone: "+txtPhone);
		System.out.println("Email: "+email);
		
		BookingEntity bookingEntity = new BookingEntity();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(txtUserId);
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		String bookingID = "B" + dateOfCreate.getTime();
		bookingEntity.setBookingId(bookingID);
		bookingEntity.setFullname(txtCustomerName);
		bookingEntity.setUser(userEntity);
		bookingEntity.setEmail(email);
		bookingEntity.setAddress(txtAddressShipping);
		bookingEntity.setPhone(txtPhone);
		bookingEntity.setDateOfCreate(dateOfCreate);
		bookingEntity.setSubTotal(subTotal);
		bookingEntity.setTax(vat);
		bookingEntity.setShipping(shippingFee);
		bookingEntity.setTotal(total);
		if (payMethod.equals("rdCash")) {
			bookingEntity.setPaymentMethod("Cash");
			bookingEntity.setStatus("waiting");
		}else if (payMethod.equals("rdPaypal")) {
			bookingEntity.setPaymentMethod("Paypal");
		}
		bookingService.save(bookingEntity);
		int count = (int) dateOfCreate.getTime();
		Collection<CartItemDTO> clik = shoppingCartService.getAllItems();
		for (CartItemDTO cartItemDTO : clik) {
			String itemId = cartItemDTO.getItemId();
			String itemName = cartItemDTO.getItemName();
			String imageUrl = cartItemDTO.getImage();
			int quantity = cartItemDTO.getQuantity();
			double price = cartItemDTO.getPrice();
			String bookingDeId = "STK"+itemId+count;
			System.out.println("Id-item in shopping cart: "+itemId);
			BookingDetailEntity bookingDetailEntity = new BookingDetailEntity();
			BookingEntity bookingId = new BookingEntity();
			bookingId.setBookingId(bookingID);
			bookingDetailEntity.setBooking(bookingId);
			bookingDetailEntity.setBookingDeId(bookingDeId);
			bookingDetailEntity.setImgUrl(imageUrl);
			ItemEntity itemEntity = new ItemEntity();
			itemEntity.setItemId(itemId);
			bookingDetailEntity.setItem(itemEntity);
			bookingDetailEntity.setItemName(itemName);
			bookingDetailEntity.setPrice(price);
			bookingDetailEntity.setQuantity(quantity);
			bookingDetailService.save(bookingDetailEntity);
		}
		shoppingCartService.clear();
		model.addAttribute("success", "Shopping Item is done!");
		return "redirect:/api/v1/customer";
	}

	@RequestMapping(value = "/api/v1/customer/addDisOnBill", method = RequestMethod.POST)
	public String addDiscount(Model model) {
		String discountId = request.getParameter("discountCbo");
		System.out.println("Discount Id: " + discountId);
		model.addAttribute("disUsing", discountService.findById(discountId));
		return "redirect:/api/v1/customer/shoppingCart/views";
	}
}
