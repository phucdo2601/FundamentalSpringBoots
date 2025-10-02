package com.phucdn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.exceptions.UserException;
import com.phucdn.payload.dto.BranchDto;
import com.phucdn.payload.response.ApiResponse;
import com.phucdn.service.BranchService;
import com.stripe.net.ApiResource;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

	private final BranchService branchService;
	
	@PostMapping
	public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branchDto) throws UserException {
		BranchDto createdBranch = branchService.createBranch(branchDto);
		
		return ResponseEntity.ok(createdBranch);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BranchDto> getBranchById(@PathVariable("id") Long id) throws Exception {
		BranchDto existingBranch = branchService.getBranchById(id);
		
		return ResponseEntity.ok(existingBranch);
	} 
	
	@GetMapping("/store/{id}")
	public ResponseEntity<List<BranchDto>> getAllBranchesByStoreId(@PathVariable("id") Long id) throws Exception {
		List<BranchDto> listBranchDtos = branchService.getAllBranchesByStoreId(id);
		
		return ResponseEntity.ok(listBranchDtos);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BranchDto> getBranchById(@PathVariable("id") Long id,
			@RequestBody BranchDto branchDto
			) throws Exception {
		BranchDto updateBranch = branchService.updateBranch(id, branchDto);
		
		return ResponseEntity.ok(updateBranch);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteBranch(@PathVariable("id") Long id) throws Exception {
		branchService.deleteBranch(id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Branch deleted successfully!");
		
		return ResponseEntity.ok(apiResponse);
	}
	
}
