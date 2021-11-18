package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.dto.BookingDTO;
import com.phucdn.learnSpringSecurity.dto.BookingDetailDTO;
import com.phucdn.learnSpringSecurity.entity.BookingDetailEntity;
import com.phucdn.learnSpringSecurity.entity.BookingEntity;
import com.phucdn.learnSpringSecurity.repository.BookingDetailRepository;
import com.phucdn.learnSpringSecurity.service.BookingDetailService;
import com.phucdn.learnSpringSecurity.service.BookingSerivce;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/bookings")
public class AdminBookingController {

	@Autowired
	private BookingSerivce bookingSerivce;
	
	@Autowired
	private BookingDetailService bookingDetailService;
	
	@Autowired
	private BookingDetailRepository bookingDetailRepository;
	
	@GetMapping("")
	public List<BookingDTO> loadAllBooking() {
		List<BookingDTO> listReturn = new ArrayList<>();
		List<BookingEntity> listAllBooking = bookingSerivce.findAll();
		for (BookingEntity bookingEntity : listAllBooking) {
			String bookingId = bookingEntity.getBookingId();
			String address = bookingEntity.getAddress();
			String discountId = bookingEntity.getDiscountId();
			Date dateOfCreate = bookingEntity.getDateOfCreate();
			String email = bookingEntity.getEmail();
			String fullName = bookingEntity.getFullName();
			String phone = bookingEntity.getPhone();
			String paymentMethod = bookingEntity.getPaymentMethod();
			Date dateOfProcess = bookingEntity.getDateOfProcess();
			String status = bookingEntity.getStatus();
			Date dateOfFinish = bookingEntity.getDateOfFinish();
			double subTotal = bookingEntity.getSubTotal();
			double shipping = bookingEntity.getShipping();
			double tax = bookingEntity.getTax();
			double total = bookingEntity.getTotal();
			String userId = bookingEntity.getUser().getUserId();
			listReturn.add(new BookingDTO(bookingId, address, 
					discountId, dateOfCreate, email, fullName, 
					phone, paymentMethod, dateOfProcess, status, 
					dateOfFinish, subTotal, shipping, tax, total, userId));
		}
		return listReturn;
	}
	
	@GetMapping("/{id}")
	public List<BookingDetailDTO> getBookingDetailByBookingId(@PathVariable("id") String bookingId) {
		List<BookingDetailDTO> listReturn = new ArrayList<>();
		List<BookingDetailEntity> listAllBookingDe = bookingDetailRepository.findBookingDetailByBookingId(bookingId);
		for (BookingDetailEntity bookingDetailEntity : listAllBookingDe) {
			String bookingDeId = bookingDetailEntity.getBookingDeId();
			String itemId = bookingDetailEntity.getItem().getItemId();
			String itemName = bookingDetailEntity.getItemName();
			String imgUrl = bookingDetailEntity.getImgUrl();
			int quantity = bookingDetailEntity.getQuantity();
			double price = bookingDetailEntity.getPrice();
			listReturn.add(new BookingDetailDTO(bookingDeId, bookingId, itemId, itemName, imgUrl, quantity, price));
			
		}
		return listReturn;
	}
}
