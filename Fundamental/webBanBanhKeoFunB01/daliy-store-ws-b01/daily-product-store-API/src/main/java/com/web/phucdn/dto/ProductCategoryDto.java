package com.web.phucdn.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDto implements Serializable {
	private String proCateCode;
	private String proCateTitle;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;
}
