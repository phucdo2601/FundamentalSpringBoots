package com.phucdn.learnRestAPICrudBasic1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@Column(name = "employee_id", columnDefinition = "nvarchar(255) not null")
	private String employeeId;
	@Column(name = "employee_name", columnDefinition = "nvarchar(255) not null")
	private String employeeName;
	@Column(name = "email", columnDefinition = "nvarchar(255) not null")
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_Start")
	private Date dateStart;
}
