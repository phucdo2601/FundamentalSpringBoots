package com.phucdn.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.inventoryservice.service.IInventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	
	private final IInventoryService inventoryService;
	
	// http://localhost:8084/api/inventory/iphone-13,iphone-14
	public List<Inventoryr>
	
	
	// http://localhost:8084/api/inventory?sku-code=iphone-13
	@GetMapping("/{sku-code}")
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@PathVariable(name = "sku-code") String skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
