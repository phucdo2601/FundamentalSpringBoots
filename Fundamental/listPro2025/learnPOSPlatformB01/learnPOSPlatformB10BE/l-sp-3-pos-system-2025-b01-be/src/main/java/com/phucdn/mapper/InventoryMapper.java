package com.phucdn.mapper;

import com.phucdn.model.Branch;
import com.phucdn.model.Inventory;
import com.phucdn.model.Product;
import com.phucdn.payload.dto.InventoryDto;

public class InventoryMapper {
	public static InventoryDto toDto(Inventory inventory) {
		return InventoryDto.builder()
				.id(inventory.getId())
				.branchId(inventory.getBranch().getId())
				.productId(inventory.getProduct().getId())
				.product(ProductMapper.toDto(inventory.getProduct()))
				.quantity(inventory.getQuantity())
				.build();
	}
	
	public static Inventory toEntity(InventoryDto inventoryDto, Branch branch, Product product) {
		return Inventory.builder()
				.branch(branch)
				.product(product)
				.quantity(inventoryDto.getQuantity())
				.build();
	}
}
