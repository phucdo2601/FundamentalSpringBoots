package com.phucdn.shoppingPage.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	private String itemId;
	private String itemName;
	private String author;
	private int quantity;
	private String imgUrl;
	private double price;
	private Date dateOfCreate;
	private String description;
	private String status;
	private String cateId;
}
