package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable{
	private String cateId;
	private String cateName;
	private Date dateOfCreate;
	private String description;
	private String status;
}
