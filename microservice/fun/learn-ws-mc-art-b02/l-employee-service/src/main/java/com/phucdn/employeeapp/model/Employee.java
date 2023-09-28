package com.phucdn.employeeapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", columnDefinition = "varchar(45)")
	private String name;
	
	@Column(name = "email", columnDefinition = "varchar(45)")
	private String email;
	
	@Column(name = "bloodgroup", columnDefinition = "varchar(45)")
	private String bloodgroup;
}
