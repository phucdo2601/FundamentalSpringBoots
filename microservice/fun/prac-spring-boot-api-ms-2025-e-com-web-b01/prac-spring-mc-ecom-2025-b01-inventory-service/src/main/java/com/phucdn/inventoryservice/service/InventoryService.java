package com.phucdn.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	@Transactional(readOnly = true)
	public boolean isInStock(String skuCode) {
		return inventoryRepository.findBySkuCode(skuCode).isEmpty();
	}

}
