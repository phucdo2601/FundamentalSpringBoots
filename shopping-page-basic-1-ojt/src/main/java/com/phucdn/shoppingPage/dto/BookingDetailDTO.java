package com.phucdn.shoppingPage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailDTO {
	private String bookingDeId;
	private String itemName;
	private String imgUrl;
	private int quantity;
	private double price;
	private String itemId;
	private String bookingId;
	
//	public String displayBookingDeDTO() {
//		return this.bookingDeId
//	}
}
