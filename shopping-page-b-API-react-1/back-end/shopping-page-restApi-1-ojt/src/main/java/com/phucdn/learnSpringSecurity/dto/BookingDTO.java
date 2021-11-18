package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO implements Serializable{
	private String bookingId;
	private String address;
	private String discountId;
	private Date dateOfCreate;
	private String email;
	private String fullName;
	private String phone;
	private String paymentMethod;
	private Date dateOfProcess;
	private String status;
	private Date dateOfFinish;
	private double subTotal;
	private double shipping;
	private double tax;
	private double total;
	private String userId;
}
