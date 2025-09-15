package com.phucdn.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.microservices.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
