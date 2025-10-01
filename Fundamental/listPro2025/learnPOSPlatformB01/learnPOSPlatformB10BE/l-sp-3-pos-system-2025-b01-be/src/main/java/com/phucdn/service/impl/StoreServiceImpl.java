package com.phucdn.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.domain.StoreContact;
import com.phucdn.domain.StoreStatus;
import com.phucdn.exceptions.UserException;
import com.phucdn.mapper.StoreMapper;
import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.payload.dto.StoreDto;
import com.phucdn.repository.StoreRepository;
import com.phucdn.service.StoreService;
import com.phucdn.service.UserService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public StoreDto createStore(StoreDto storeDto, User user) {
		Store store = StoreMapper.toEntity(storeDto, user);

		return StoreMapper.toDto(storeRepository.save(store));
	}

	@Override
	public StoreDto getStoreById(Long id) throws Exception {
		Store store = storeRepository.findById(id).orElseThrow(() -> new Exception("Store not found"));

		return StoreMapper.toDto(store);
	}

	@Override
	public List<StoreDto> getAllStores() {
		List<Store> listStores = storeRepository.findAll();
		return listStores.stream().map(StoreMapper::toDto).collect(Collectors.toList());
		
	}

	@Override
	public Store getStoreByAdmin() throws UserException {
		User admin = userService.getCurrentUser();
		return storeRepository.findByStoreAdminId(admin.getId());
	}

	@Override
	public StoreDto updateStore(Long id, StoreDto storeDto) throws Exception {
		// TODO Auto-generated method stub
		User currentUser = userService.getCurrentUser();
		Store existingStore = storeRepository.findByStoreAdminId(currentUser.getId());
		if (existingStore == null) {
			throw new Exception("Store not found!");
		}
		
		existingStore.setBrand(storeDto.getBrand());
		existingStore.setDescription(storeDto.getDescription());
		
		if (storeDto.getStoreType() != null) {
			existingStore.setStoreType(storeDto.getStoreType());
		}
		
		if (storeDto.getContact() != null) {
			StoreContact contact = StoreContact.builder()
					.address(storeDto.getContact().getAddress())
					.phone(storeDto.getContact().getPhone())
					.email(storeDto.getContact().getEmail())
					.build();
			existingStore.setContact(contact);
		}
		
		Store updatedStore = storeRepository.save(existingStore);
		
		return StoreMapper.toDto(updatedStore);
	}

	@Override
	public void deleteStore(Long id) throws UserException {
		Store store = getStoreByAdmin();
		storeRepository.delete(store);
	}

	@Override
	public StoreDto getStoreByEmployee() throws UserException {
		User currentUser = userService.getCurrentUser();
		
		if (currentUser == null) {
			throw new UserException("You dont have permission to access this store");
		}
		
		return StoreMapper.toDto(currentUser.getStore());
	}

	@Override
	public StoreDto moderateStore(Long id, StoreStatus status) throws Exception {
		Store store = storeRepository.findById(id).orElseThrow(
				() -> new Exception("Store not found")
				);
		
		store.setStatus(status);
		Store updatedStore = storeRepository.save(store);
		
		return StoreMapper.toDto(updatedStore);
	}

}
