package com.phucdn.shoppingPage.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	private String bookingId;
	private String fullname;
	private String phone;
	private String email;
	private String address;
	private Date dateOfCreate;
	private String discountId;
	private String paymentMethod;
	private double subTotal;
	private double shipping;
	private double tax;
	private double total;
	private String status;
	private String userId;
}
