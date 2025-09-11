package com.web.phucdn.dto.request;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCouponGeneralTypeDto {
	private String proCateCode;
	private String proCateTitle;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;
}
