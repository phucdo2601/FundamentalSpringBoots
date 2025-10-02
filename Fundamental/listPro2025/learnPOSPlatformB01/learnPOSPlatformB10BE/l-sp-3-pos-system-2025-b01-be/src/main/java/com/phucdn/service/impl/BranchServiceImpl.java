package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.exceptions.UserException;
import com.phucdn.mapper.BranchMapper;
import com.phucdn.model.Branch;
import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.payload.dto.BranchDto;
import com.phucdn.repository.BranchRepository;
import com.phucdn.repository.StoreRepository;
import com.phucdn.service.BranchService;
import com.phucdn.service.UserService;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public BranchDto createBranch(BranchDto branchDto) throws UserException {
		User currnentUser = userService.getCurrentUser();
		Store store = storeRepository.findByStoreAdminId(currnentUser.getId());
		
		Branch branch = BranchMapper.toEntity(branchDto, store);
		
		Branch savedBranch = branchRepository.save(branch);
		
		return BranchMapper.toDto(savedBranch);
	}

	@Override
	public BranchDto updateBranch(Long id, BranchDto branchDto) throws Exception {
		Branch existingBranch = branchRepository.findById(id).orElseThrow(() -> new Exception("Branch not exist..."));
		
		existingBranch.setName(branchDto.getName());
		existingBranch.setWorkingDays(branchDto.getWorkingDays());
		existingBranch.setEmail(branchDto.getEmail());
		existingBranch.setPhone(branchDto.getEmail());
		existingBranch.setAddress(branchDto.getAddress());
		existingBranch.setOpenTime(branchDto.getOpenTime());
		existingBranch.setCloseTime(branchDto.getCloseTime());
		existingBranch.setUpdatedAt(LocalDateTime.now());
		
		Branch updatedBranch = branchRepository.save(existingBranch);
		
		return BranchMapper.toDto(updatedBranch);
	}

	@Override
	public void deleteBranch(Long id) throws Exception {
		Branch existingBranch = branchRepository.findById(id).orElseThrow(() -> new Exception("Branch not exist..."));
		branchRepository.delete(existingBranch);
	}

	@Override
	public List<BranchDto> getAllBranchesByStoreId(Long storeId) {
		List<Branch> listBranches = branchRepository.findByStoreId(storeId);
		return listBranches.stream().map(BranchMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public BranchDto getBranchById(Long id) throws Exception {
		Branch existingBranch = branchRepository.findById(id).orElseThrow(() -> new Exception("Branch not exist..."));
		return BranchMapper.toDto(existingBranch);
	}

}
