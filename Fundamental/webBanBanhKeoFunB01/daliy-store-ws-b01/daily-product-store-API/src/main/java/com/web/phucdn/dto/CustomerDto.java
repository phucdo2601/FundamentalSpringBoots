package com.web.phucdn.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
	private String customerCode;
	private String customerPoint;
	private Timestamp lastPurchaseDate;
}
