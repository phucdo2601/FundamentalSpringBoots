package com.phucdn.learnSpringSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
	private String itemId;
	private String itemName;
	private String image;
	private int quantity;
	private double price;
}
