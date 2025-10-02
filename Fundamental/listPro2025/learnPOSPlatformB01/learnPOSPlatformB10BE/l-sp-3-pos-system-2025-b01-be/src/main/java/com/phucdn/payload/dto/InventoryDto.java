package com.phucdn.payload.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDto {
	private Long id;
	
	private BranchDto branch;
	
	private Long branchId;
	
	private Long productId;
	
	private ProductDto product;
	
	private Integer quantity;
	
	private LocalDateTime lastUpdate;
}
