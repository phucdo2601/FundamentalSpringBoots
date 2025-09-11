package com.web.phucdn.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffRoleDto implements Serializable {
	private String staffRoleCode;
	private String staffRoleTitle;
}
