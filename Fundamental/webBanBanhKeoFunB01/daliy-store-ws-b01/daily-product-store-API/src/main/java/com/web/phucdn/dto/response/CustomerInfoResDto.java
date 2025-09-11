package com.web.phucdn.dto.response;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoResDto implements Serializable {
	private String fullName;
	private String userName;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Timestamp dateOfBirth;
	private String gender;
	private String address;
	private UUID genRoleId;
	private boolean isActive;
	private String customerCode;
	private Float customerPoint;
	private Timestamp lastPurchaseDate;
}
