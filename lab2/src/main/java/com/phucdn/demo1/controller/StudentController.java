package com.phucdn.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentController {
	@GetMapping("new")
	public String newForm() {
		return "student/new";
	}
	
	@PostMapping("saveOrUpdate")
	public static String saveOrUpdate() {
		return "students/edit";
	}
	
	public static String list() {
		
	}
}
