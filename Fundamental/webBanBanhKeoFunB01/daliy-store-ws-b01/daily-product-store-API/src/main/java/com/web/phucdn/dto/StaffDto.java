package com.web.phucdn.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto implements Serializable {
	private String staffCode;
	private UUID genUserInfoId;
	private UUID staffRoleId;
}
