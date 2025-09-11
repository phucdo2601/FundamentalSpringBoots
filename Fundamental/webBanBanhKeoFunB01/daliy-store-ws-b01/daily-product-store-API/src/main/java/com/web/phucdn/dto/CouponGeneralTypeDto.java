package com.web.phucdn.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponGeneralTypeDto  implements Serializable{
    private String couGenTypeCode;
	private String couGenTypeTitle;
	private Timestamp dateOfCreate;
	private String statusId;
	private Timestamp dateOfUpdate;
}
