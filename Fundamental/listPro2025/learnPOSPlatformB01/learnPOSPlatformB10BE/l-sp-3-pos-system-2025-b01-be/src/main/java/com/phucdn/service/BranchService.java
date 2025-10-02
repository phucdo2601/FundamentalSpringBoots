package com.phucdn.service;

import java.util.List;

import com.phucdn.exceptions.UserException;
import com.phucdn.model.User;
import com.phucdn.payload.dto.BranchDto;

public interface BranchService {
	BranchDto createBranch(BranchDto branchDto) throws UserException;
	BranchDto updateBranch(Long id, BranchDto branchDto) throws Exception;
	void deleteBranch(Long id) throws Exception;
	List<BranchDto> getAllBranchesByStoreId(Long storeId);
	BranchDto getBranchById(Long id) throws Exception;
}
