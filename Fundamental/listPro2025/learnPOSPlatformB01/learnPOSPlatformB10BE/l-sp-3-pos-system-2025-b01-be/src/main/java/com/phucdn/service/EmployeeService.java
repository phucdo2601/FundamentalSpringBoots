package com.phucdn.service;

import java.util.List;

import com.phucdn.domain.UserRole;
import com.phucdn.model.User;
import com.phucdn.payload.dto.UserDto;

public interface EmployeeService {

	UserDto createStoreEmployee(UserDto employee, Long storeId) throws Exception;
	UserDto createBranchEmployee(UserDto employee, Long branchId) throws Exception;
	User updateEmployee(Long employeeId, UserDto employeeDetails) throws Exception;
	void deleteEmployee(Long employeeId) throws Exception;
	List<User>  findStoreEmployees(Long storeId, UserRole role) throws Exception;
	List<User> findBranchEmployees(Long branchId, UserRole role) throws Exception;
}
