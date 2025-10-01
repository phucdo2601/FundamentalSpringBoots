package com.phucdn.service;

import java.util.List;

import com.phucdn.domain.StoreStatus;
import com.phucdn.exceptions.UserException;
import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.payload.dto.StoreDto;

public interface StoreService {

	StoreDto createStore(StoreDto storeDto, User user);
	StoreDto getStoreById(Long id) throws Exception;
	List<StoreDto> getAllStores();
	Store getStoreByAdmin() throws UserException;
	StoreDto updateStore(Long id, StoreDto storeDto) throws UserException, Exception;
	void deleteStore(Long id) throws UserException;
	StoreDto getStoreByEmployee() throws UserException;
	
	StoreDto moderateStore(Long id, StoreStatus status) throws Exception;
}
