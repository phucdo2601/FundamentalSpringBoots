package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements Serializable{
	private String itemId;
	private String itemName;
	private String author;
	private Date dateOfCreate;
	private String description;
	private String imgUrl;
	private double price;
	private int quantity;
	private String status;
	private String cateId;
}
