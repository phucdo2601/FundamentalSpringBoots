package com.phucdn.shoppingPage.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/admin")
public class AdminManagenmentController {

	@GetMapping()
	public String loadAdminManagementPage() {
		return "admin/adminManagement";
	}
}
