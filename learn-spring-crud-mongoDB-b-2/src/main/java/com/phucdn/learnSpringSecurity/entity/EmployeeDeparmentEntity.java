package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDeparmentEntity extends BaseEntity implements Serializable{
	
	@NotBlank
	private String empId;
	@NotBlank
	private String depId;
}
