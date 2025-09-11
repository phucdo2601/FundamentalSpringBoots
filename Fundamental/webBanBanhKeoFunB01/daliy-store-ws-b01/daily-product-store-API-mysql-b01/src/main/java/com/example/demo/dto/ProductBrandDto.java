package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrandDto implements Serializable {
	private String brandCode;
	private String brandName;
	private String description;
	private Timestamp dateOfCreate;
}
