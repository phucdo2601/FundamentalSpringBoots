package com.phucdn.shoppingPage.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	private String cateId;
	private String cateName;
	private Date dateOfCreate;
	private boolean status;
}
