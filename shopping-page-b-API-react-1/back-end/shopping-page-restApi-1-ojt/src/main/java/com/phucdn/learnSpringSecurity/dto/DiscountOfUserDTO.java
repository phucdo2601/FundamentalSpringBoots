package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountOfUserDTO implements Serializable {
	private String discountId;
	private String discountName;
	private double rateDis;
	private Date dateOfCreate;
	private String description;
	private String status;
}
