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

import com.phucdn.payload.dto.InventoryDto;
import com.phucdn.payload.response.ApiResponse;
import com.phucdn.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {
	
	private final InventoryService inventoryService;
	
	@PostMapping
	public ResponseEntity<InventoryDto> create(@RequestBody InventoryDto inventoryDto) throws Exception {
		return ResponseEntity.ok(inventoryService.createInventory(inventoryDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InventoryDto> update(@PathVariable("id") Long id, @RequestBody InventoryDto inventoryDto) throws Exception {
		return ResponseEntity.ok(inventoryService.updateInventory(id, inventoryDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id) throws Exception {
		inventoryService.deleteInventory(id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Inventory deleted successfully!");
		
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/branch/{branchId}/product/{productId}")
	public ResponseEntity<InventoryDto> getInvetoryByProductAndBranchId(
			@PathVariable("branchId") Long branchId,
			@PathVariable("productId") Long productId
			) {
		return ResponseEntity.ok(inventoryService.getInventoryByProductIdAndBranchId(productId, branchId));
	}
	
	@GetMapping("/branch/{branchId}")
	public ResponseEntity<List<InventoryDto>> getInvetoryByBranch(@PathVariable("branchId") Long branchId) {
		return ResponseEntity.ok(inventoryService.getAllInventoryByBranchId(branchId));
	}
}
