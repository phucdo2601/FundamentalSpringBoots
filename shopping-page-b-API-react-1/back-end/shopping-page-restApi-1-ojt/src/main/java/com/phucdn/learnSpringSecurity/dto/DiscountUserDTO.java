package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountUserDTO implements Serializable{
	private Integer id;
	private Date dateOfAdd;
	private String userId;
	private String discountId;
	private String status;
}
