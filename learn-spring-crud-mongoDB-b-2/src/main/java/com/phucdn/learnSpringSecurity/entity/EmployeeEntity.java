package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class EmployeeEntity extends BaseEntity implements Serializable {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Field(name = "emp_id")
	private String empId;
	@Field(name = "first_name")
	private String firstName;
	@Field(name = "last_name")
	private String lastName;
	
	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	@Field(name = "email_id")
	private String emailId;
	
}
