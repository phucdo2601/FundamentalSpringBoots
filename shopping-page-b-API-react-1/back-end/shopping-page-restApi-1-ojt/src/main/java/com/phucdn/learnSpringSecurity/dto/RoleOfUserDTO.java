package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleOfUserDTO implements Serializable{
	private String roleId;
	private String roleName;
	private Date dateOfCreate;
	private String description;
	private String status;
}
