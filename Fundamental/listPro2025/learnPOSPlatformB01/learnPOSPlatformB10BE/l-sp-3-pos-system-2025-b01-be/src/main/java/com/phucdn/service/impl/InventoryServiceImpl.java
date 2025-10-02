package com.phucdn.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.mapper.InventoryMapper;
import com.phucdn.model.Branch;
import com.phucdn.model.Inventory;
import com.phucdn.model.Product;
import com.phucdn.payload.dto.InventoryDto;
import com.phucdn.repository.BranchRepository;
import com.phucdn.repository.InventoryRepository;
import com.phucdn.repository.ProductRepository;
import com.phucdn.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public InventoryDto createInventory(InventoryDto inventoryDto) throws Exception {
		Branch existingBranch = branchRepository.findById(inventoryDto.getBranchId()).orElseThrow(() -> new Exception("Branch not exist..."));
		
		Product existingProduct = productRepository.findById(inventoryDto.getProductId()).orElseThrow(() -> new Exception("Product not found!"));
		
		Inventory inventory = InventoryMapper.toEntity(inventoryDto, existingBranch, existingProduct);
		Inventory savedInventory = inventoryRepository.save(inventory);
		
		return InventoryMapper.toDto(savedInventory);
	}

	@Override
	public InventoryDto updateInventory(Long id, InventoryDto inventoryDto) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new Exception("Inventory not exist..."));
		inventory.setQuantity(inventoryDto.getQuantity());
		
		Inventory updatedInventory = inventoryRepository.save(inventory);
		
		return InventoryMapper.toDto(updatedInventory);
	}

	@Override
	public void deleteInventory(Long id) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new Exception("Inventory not exist..."));
		inventoryRepository.delete(inventory);
	}

	@Override
	public InventoryDto getInventoryById(Long id) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new Exception("Inventory not exist..."));
		return InventoryMapper.toDto(inventory);
	}

	@Override
	public InventoryDto getInventoryByProductIdAndBranchId(Long productId, Long branchId) {
		Inventory inventory = inventoryRepository.findByProductIdAndBranchId(productId, branchId);
		return InventoryMapper.toDto(inventory);
	}

	@Override
	public List<InventoryDto> getAllInventoryByBranchId(Long branchId) {
		List<Inventory> inventories = inventoryRepository.findByBranchId(branchId);
		
		return inventories.stream().map(InventoryMapper::toDto).collect(Collectors.toList());
	}

}
