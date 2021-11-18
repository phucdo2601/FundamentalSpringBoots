package com.phucdn.shoppingPage.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.shoppingPage.dto.BookingDetailDTO;
import com.phucdn.shoppingPage.entity.BookingDetailEntity;
import com.phucdn.shoppingPage.entity.BookingEntity;
import com.phucdn.shoppingPage.repository.BookingDetailRepository;
import com.phucdn.shoppingPage.repository.BookingRepository;
import com.phucdn.shoppingPage.service.BookingDetailService;
import com.phucdn.shoppingPage.service.BookingService;

@Controller
@RequestMapping("/api/v1/admin/bookings")
public class AdminBookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingDetailService bookingDetailService;
	
	@Autowired
	private BookingDetailRepository bookingDetailRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

	@GetMapping()
	public String loadBookingPage(Model model) {
		model.addAttribute("listBooking", bookingService.findAll());
		return "admin/bookings/booking";
	}
	
	@GetMapping("/searchById")
	public String searchBookingById(ModelMap model, @RequestParam(name = "bookingSearch", required = false) String bookingId) {
		List<BookingEntity> listAResult = bookingRepository.searchBookingLikeByBookingId(bookingId);
		model.addAttribute("aListSearchBooking", listAResult);
		
		return "admin/bookings/booking";
	}
	
	@GetMapping("/viewBookingDetail/{id}")
	public ModelAndView viewBookingDetailById(@PathVariable("id") String bookingId) {
		ModelAndView mav = new ModelAndView("admin/bookings/bookingDetail");
		List<BookingDetailEntity> bookingDeEntity = bookingDetailRepository.findBookingDetailByBookingId(bookingId);
//		List<BookingDetailDTO>  bookingObj = new ArrayList<>();
//		String itemId = null;
//		for (BookingDetailEntity book : bookingDeEntity) {
//			itemId = book.getItem().getItemId();
//			System.out.println(book.getItem().getItemId());
//		}
//		
//		BeanUtils.copyProperties(bookingDeEntity, bookingObj);
//		for (BookingDetailDTO bookObj : bookingObj) {
//			bookObj.setItemId(itemId);
//			bookObj.setBookingId(bookingId);
//			System.out.println("ItemId: "+bookObj.getItemId());
//			System.out.println("ItemName: "+bookObj.getItemName());
//			System.out.println("Price: "+bookObj.getPrice());
//		}
		
		for (BookingDetailEntity bookingEn : bookingDeEntity) {
			System.out.println(bookingEn.getBookingDeId());
			System.out.println(bookingEn.getImgUrl());
		}
		
		mav.addObject("listBookingDe", bookingDeEntity);
		return mav;
	}
}
