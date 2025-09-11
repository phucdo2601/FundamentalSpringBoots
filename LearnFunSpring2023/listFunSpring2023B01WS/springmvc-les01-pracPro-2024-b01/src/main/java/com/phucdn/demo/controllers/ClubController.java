package com.phucdn.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.phucdn.demo.dtos.ClubDto;
import com.phucdn.demo.models.Club;
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

	@GetMapping("/clubs/new")
	public String createClubForm(Model model) {
		Club club = new Club();
		model.addAttribute("club", club);
		return "clubs-create";
	}

	@PostMapping("/clubs/new")
	public String saveClub(@ModelAttribute("club") Club club) {
	}
}
