package com.web.phucdn.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.GeneralRoleDto;
import com.web.phucdn.models.GeneralRole;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IGeneralRoleService;

@RestController
@RequestMapping("/api/v1/generalRole")
public class GeneralRoleController extends BaseController<GeneralRole, GeneralRoleDto, IGeneralRoleService> {

	public GeneralRoleController(BaseService<GeneralRole, GeneralRoleDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
