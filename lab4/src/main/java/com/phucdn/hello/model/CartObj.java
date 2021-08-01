package com.phucdn.hello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartObj {
	private int productID;
	private String name;
	private int quantity;
	private double price;
}
