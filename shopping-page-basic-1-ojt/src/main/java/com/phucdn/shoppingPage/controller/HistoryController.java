package com.phucdn.shoppingPage.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phucdn.shoppingPage.dto.BookingDetailDTO;
import com.phucdn.shoppingPage.entity.BookingDetailEntity;
import com.phucdn.shoppingPage.entity.BookingEntity;
import com.phucdn.shoppingPage.repository.BookingDetailRepository;
import com.phucdn.shoppingPage.repository.BookingRepository;
import com.phucdn.shoppingPage.service.BookingService;

@Controller
public class HistoryController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private BookingDetailRepository bookingDetailRepository;

	@RequestMapping(value = "/api/v1/history", method = RequestMethod.GET)
	public String viewListHistory(Model model, Principal principal) {
		// Sau khi login thanh cong se co principal
		String userName = principal.getName();
		System.out.println("Username: " + userName);

		User loginnedUser = (User) ((Authentication) principal).getPrincipal();
		List<BookingEntity> listAResult = bookingRepository.searchBookingLikeByUserId(userName);
		model.addAttribute("listHistoryByUserId", listAResult);
		
		return "historyShopping";
	}
	
	@RequestMapping(value = "/api/v1/history/view-his-de/{id}", method = RequestMethod.GET)
	public String viewListHistoryDetail(@PathVariable("id") String bookingId, Model model) {
		List<BookingDetailDTO> listReturn = new ArrayList<>();
		List<BookingDetailEntity> listBookingDe = bookingDetailRepository.findBookingDetailByBookingId(bookingId);
		for (BookingDetailEntity bookingDetailEntity : listBookingDe) {
			String itemName = bookingDetailEntity.getItemName();
			String itemId = bookingDetailEntity.getItem().getItemId();
			String imgUrl = bookingDetailEntity.getImgUrl();
			int quantity = bookingDetailEntity.getQuantity();
			double price = bookingDetailEntity.getPrice();
			listReturn.add(new BookingDetailDTO(bookingId, itemName, imgUrl, quantity, price, itemId, bookingId));
		}
		model.addAttribute("listHisDetailByBookingId", listReturn);
		return "historyShopping";
	}
}
