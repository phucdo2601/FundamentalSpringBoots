package com.phucdn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BusinessDetails {
	private String businessName;
	private String businessEmail;
	private String businessMobile;
	private String bussinessAddress;
	private String logo;
	private String banner;
}
