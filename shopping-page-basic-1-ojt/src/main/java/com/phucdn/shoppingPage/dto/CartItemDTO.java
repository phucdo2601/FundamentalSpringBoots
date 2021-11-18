package com.phucdn.shoppingPage.dto;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
	private String itemId;
	private String itemName;
	private double price;
	private int quantity;
	private String image;
}
