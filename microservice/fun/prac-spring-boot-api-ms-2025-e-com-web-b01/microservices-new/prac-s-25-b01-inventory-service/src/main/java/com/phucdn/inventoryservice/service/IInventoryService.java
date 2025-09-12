package com.phucdn.inventoryservice.service;

import java.util.List;

import com.phucdn.inventoryservice.dto.InventoryResponse;

public interface IInventoryService {
	boolean isInStock(String skuCode);
	
	List<InventoryResponse> isListInStock(List<String> skuCode);
}
