package com.example.demo.services.impl;

import org.springframework.stereotype.Service;

import com.example.demo.models.BaseEntity;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.services.BaseService;

@Service
public class BaseServiceImpl<T extends BaseEntity, C> implements BaseService<T, C> {

	@Override
	public BaseRepository<T> getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C convertEntityToDto(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T convertDtoToEntity(C c) {
		// TODO Auto-generated method stub
		return null;
	}

}
