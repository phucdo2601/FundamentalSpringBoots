package com.phucdn.learnSpringSecurity.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
	@Id
	private String id;
	@Field(name = "description")
	private String description;
	@Field(name = "create_by")
	private String createBy;
	@Field(name = "date_of_create")
	private Date dateOfCreate;
	@Field(name = "status")
	private String status;
	@Field(name = "date_of_update")
	private Date dateOfUpdate;
	@Field(name = "update_by")
	private String updateBy;
	
}
