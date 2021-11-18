package com.phucdn.shoppingPage.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
	private String discountId;
	private String discountName;
	private double rateDis;
	private boolean isUsing;
	private Date dateOfCreate;
	private String userId;
	private String status;
}
