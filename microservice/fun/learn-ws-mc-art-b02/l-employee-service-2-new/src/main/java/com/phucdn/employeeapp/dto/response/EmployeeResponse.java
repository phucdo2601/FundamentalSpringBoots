package com.phucdn.employeeapp.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	private Integer id;
	private String name;
	private String email;
	private String bloodGroup;
	private List<AddressResponse> addressResponse;
}
