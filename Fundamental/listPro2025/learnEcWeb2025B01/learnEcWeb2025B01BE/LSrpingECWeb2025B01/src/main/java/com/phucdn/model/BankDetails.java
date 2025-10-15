package com.phucdn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BankDetails {
	private String accountNumber;
	
	private String accountHolderName;
	
	private String ifscCode;
}

