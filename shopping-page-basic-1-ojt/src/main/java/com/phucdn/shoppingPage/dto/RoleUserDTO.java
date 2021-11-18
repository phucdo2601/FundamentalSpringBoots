package com.phucdn.shoppingPage.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUserDTO {
	private String roleId;
	private String roleName;
	private String statusRole;
}
