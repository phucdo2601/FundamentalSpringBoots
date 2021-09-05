package com.phucdn.learnRestAPICrudBasic1.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private String employeeId;
	private String employeeName;
	private String email;
	private Date dateStart;
}
