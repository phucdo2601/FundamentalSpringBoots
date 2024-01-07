package com.phucdn.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.demo.dtos.ClubDto;
import com.phucdn.demo.models.Club;
import com.phucdn.demo.repositories.ClubRepository;
import com.phucdn.demo.services.ClubService;

@Service
public class ClubServiceImpl implements ClubService{

	@Autowired
	private ClubRepository clubRepository;
	
	@Override
	public List<ClubDto> findAllClubs() {
		// TODO Auto-generated method stub
		List<Club> clubs = clubRepository.findAll();
		
		
		return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
	}
	
	private ClubDto mapToClubDto(Club club) {
		ClubDto clubDto = ClubDto.builder()
				.id(club.getId())
				.title(club.getTitle())
				.content(club.getContent())
				.photoUrl(club.getPhotoUrl())
				.createdOn(club.getCreatedOn())
				.updatedOn(club.getUpdatedOn())
				.build();
		
		return clubDto;
	}

}
