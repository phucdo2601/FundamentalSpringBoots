package com.phucdn.learnSpringSecurity.dto.authorization;

public interface PermissionChecker {

	Integer listDepartment();
	Integer createDepartment();
	Integer updateDepartment();
	Integer deleteDepartment();
	
	Integer listEmployee();
	Integer createEmployee();
	Integer updateEmployee();
	Integer deleteEmployee();
}
