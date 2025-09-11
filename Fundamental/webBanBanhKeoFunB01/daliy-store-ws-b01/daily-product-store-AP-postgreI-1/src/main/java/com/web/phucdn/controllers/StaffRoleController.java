package com.web.phucdn.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.StaffRoleDto;
import com.web.phucdn.models.StaffRole;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IStaffRoleService;

@RestController
@RequestMapping("api/v1/staffRole")
public class StaffRoleController extends BaseController<StaffRole, StaffRoleDto, IStaffRoleService> {

	public StaffRoleController(BaseService<StaffRole, StaffRoleDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
