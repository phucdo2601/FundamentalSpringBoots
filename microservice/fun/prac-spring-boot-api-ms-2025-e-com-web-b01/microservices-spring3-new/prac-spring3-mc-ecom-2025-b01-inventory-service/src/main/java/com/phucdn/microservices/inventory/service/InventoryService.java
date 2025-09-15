package com.phucdn.microservices.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.microservices.inventory.repository.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public boolean isInStock(String skuCode, Integer quantity) {
		return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
	}

}
