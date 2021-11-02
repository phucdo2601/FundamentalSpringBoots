package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class EmployeeEntity implements Serializable {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	private String firstName;
	private String lastName;
	
	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String emailId;
	
}
