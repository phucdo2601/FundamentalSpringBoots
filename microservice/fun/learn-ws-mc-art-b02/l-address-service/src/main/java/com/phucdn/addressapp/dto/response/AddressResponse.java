package com.phucdn.addressapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
	
	private Integer id;
	private String lane1;
	private String lane2;
	private String state;
	private String zip;
}
