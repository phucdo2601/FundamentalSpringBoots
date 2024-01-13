package com.phucdn.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phucdn.demo.dtos.ClubDto;
import com.phucdn.demo.services.ClubService;

@Controller
public class ClubController {

	private ClubService clubService;
	
	@Autowired
	public ClubController(ClubService clubService) {
		// TODO Auto-generated constructor stub
		this.clubService = clubService;
	}
	
	@GetMapping("/clubs")
	public String listClubs(Model model) {
		List<ClubDto> clubs = clubService.findAllClubs();
		model.addAttribute("clubs", clubs);
		
		return "clubs-list";
	}
}
