package com.phucdn.microservices.inventory.service;

public interface IInventoryService {
	boolean isInStock(String skuCode, Integer quantity);
}
