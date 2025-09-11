package com.example.demo.dto.request;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCategoryDto implements Serializable {
	private String proCateCode;
	private String proCateTitle;
	private Date dateOfCreate;
	private Date dateOfUpdate;
	private String statusId;
}
