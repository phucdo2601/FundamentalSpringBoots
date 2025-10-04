package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phucdn.domain.UserRole;
import com.phucdn.mapper.UserMapper;
import com.phucdn.model.Branch;
import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.payload.dto.UserDto;
import com.phucdn.repository.BranchRepository;
import com.phucdn.repository.StoreRepository;
import com.phucdn.repository.UserRepository;
import com.phucdn.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createStoreEmployee(UserDto employee, Long storeId) throws Exception {
		// TODO Auto-generated method stub
		Store store = storeRepository.findById(storeId).orElseThrow(() -> new Exception("Store not found!"));

		Branch branch = null;

		if (employee.getRole() == UserRole.ROLE_BRANCH_MANAGER) {
			if (employee.getBranchId() == null) {
				throw new Exception("Branch id is required to create branch manager");
			}
			branch = branchRepository.findById(employee.getBranchId())
					.orElseThrow(() -> new Exception("Branch is not found!"));
		}

		User user = UserMapper.toEntity(employee);
		user.setStore(store);
		user.setBranch(branch);
		user.setPassword(passwordEncoder.encode(employee.getPassword()));
		user.setCreatedDate(LocalDateTime.now());
		user.setUpdatedDate(LocalDateTime.now());

		User savedEmployee = userRepository.save(user);

		if (employee.getRole() == UserRole.ROLE_BRANCH_MANAGER && branch != null) {
			branch.setManager(savedEmployee);
			branchRepository.save(branch);
		}

		return UserMapper.toDto(savedEmployee);
	}

	@Override
	public UserDto createBranchEmployee(UserDto employee, Long branchId) throws Exception {
		Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new Exception("Branch is not found!"));

		// ADMIN
		if (employee.getRole().equals(UserRole.ROLE_BRANCH_CASHIER)
				|| employee.getRole().equals(UserRole.ROLE_BRANCH_MANAGER)) {
			User user = UserMapper.toEntity(employee);
			user.setBranch(branch);
			user.setPassword(passwordEncoder.encode(employee.getPassword()));

			return UserMapper.toDto(userRepository.save(user));
		}

		throw new Exception("Branch role not supported");
	}

	@Override
	public User updateEmployee(Long employeeId, UserDto employeeDetails) throws Exception {
		User existingEmployee = userRepository.findById(employeeId)
				.orElseThrow(() -> new Exception("Employee not exist with given id"));

		Branch branch = branchRepository.findById(employeeDetails.getBranchId())
				.orElseThrow(() -> new Exception("Branch not found"));

		existingEmployee.setEmail(employeeDetails.getEmail());
		existingEmployee.setFullName(employeeDetails.getFullName());
		existingEmployee.setPassword(employeeDetails.getPassword());
		existingEmployee.setRole(employeeDetails.getRole());
		existingEmployee.setBranch(branch);

		return userRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeId) throws Exception {
		User employee = userRepository.findById(employeeId).orElseThrow(() -> new Exception("Employee not found"));
		userRepository.delete(employee);

	}

	@Override
	public List<UserDto> findStoreEmployees(Long storeId, UserRole role) throws Exception {
		// TODO Auto-generated method stub
		Store store = storeRepository.findById(storeId).orElseThrow(() -> new Exception("Store not found!"));

		List<User> listEmployee = userRepository.findByStore(store).stream().filter(user -> role == null || user.getRole() == role)
				.collect(Collectors.toList());
		return listEmployee.stream().map(UserMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> findBranchEmployees(Long branchId, UserRole role) throws Exception {
		// TODO Auto-generated method stub
		Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new Exception("Branch not found"));

		List<User> listEmployee = userRepository.findByBranchId(branchId).stream()
				.filter(user -> role == null || user.getRole() == role).collect(Collectors.toList());
		return listEmployee.stream().map(UserMapper::toDto).collect(Collectors.toList());
	}

}
