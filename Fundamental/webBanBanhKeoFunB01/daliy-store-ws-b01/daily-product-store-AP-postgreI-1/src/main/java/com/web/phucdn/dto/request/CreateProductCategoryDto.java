package com.web.phucdn.dto.request;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCategoryDto implements Serializable {
	private String proCateCode;
	private String proCateTitle;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;
}
