package com.phucdn.learnSpringSecurity.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "departments")
public class DepartmentEntity extends BaseEntity{
	@Field("dep_id")
	private String depId;
	@Field("dept_name")
	private String depName;
	
}
