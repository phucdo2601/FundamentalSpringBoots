package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailDTO implements Serializable{
	private String bookingDeId;
	private String bookingId;
	private String itemId;
	private String itemName;
	private String imgUrl;
	private int quantity;
	private double price;
}
