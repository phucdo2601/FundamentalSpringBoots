package com.phucdn.mapper;

import com.phucdn.model.Branch;
import com.phucdn.model.Store;
import com.phucdn.payload.dto.BranchDto;

public class BranchMapper {
	public static BranchDto toDto(Branch branch) {
		return BranchDto.builder()
				.id(branch.getId())
				.name(branch.getName())
				.address(branch.getAddress())
				.phone(branch.getPhone())
				.email(branch.getEmail())
				.closeTime(branch.getCloseTime())
				.openTime(branch.getOpenTime())
				.workingDays(branch.getWorkingDays())
				.storeId(branch.getStore() != null ? branch.getStore().getId() : null)
				.createdAt(branch.getCreatedAt())
				.updatedAt(branch.getUpdatedAt())
				.build();
	}
	
	public static Branch toEntity(BranchDto branchDto, Store store) {
		return Branch.builder()
				.id(branchDto.getId())
				.name(branchDto.getName())
				.address(branchDto.getAddress())
				.store(store)
				.phone(branchDto.getPhone())
				.email(branchDto.getEmail())
				.closeTime(branchDto.getCloseTime())
				.openTime(branchDto.getOpenTime())
				.workingDays(branchDto.getWorkingDays())
				.createdAt(branchDto.getCreatedAt())
				.updatedAt(branchDto.getUpdatedAt())
				.build();
	}
}
