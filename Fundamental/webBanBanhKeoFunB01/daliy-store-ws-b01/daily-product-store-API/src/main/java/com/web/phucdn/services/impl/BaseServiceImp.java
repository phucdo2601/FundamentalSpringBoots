package com.web.phucdn.services.impl;

import org.springframework.stereotype.Service;

import com.web.phucdn.models.BaseEntity;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.services.BaseService;

@Service
public class BaseServiceImp<T extends BaseEntity, C> implements BaseService<T, C> {

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
