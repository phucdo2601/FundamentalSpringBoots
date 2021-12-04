package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.LockerEntity;
import com.phucdn.learnSpringSecurity.repository.LockerRepository;
import com.phucdn.learnSpringSecurity.service.LockerService;

@Service
public class LockerServiceImpl implements LockerService{

	@Autowired
	private LockerRepository lokerRepository;

	@Override
	public <S extends LockerEntity> S save(S entity) {
		return lokerRepository.save(entity);
	}

	@Override
	public <S extends LockerEntity> Optional<S> findOne(Example<S> example) {
		return lokerRepository.findOne(example);
	}

	@Override
	public Page<LockerEntity> findAll(Pageable pageable) {
		return lokerRepository.findAll(pageable);
	}

	@Override
	public <S extends LockerEntity> List<S> saveAll(Iterable<S> entities) {
		return lokerRepository.saveAll(entities);
	}

	@Override
	public List<LockerEntity> findAll() {
		return lokerRepository.findAll();
	}

	@Override
	public List<LockerEntity> findAll(Sort sort) {
		return lokerRepository.findAll(sort);
	}

	@Override
	public <S extends LockerEntity> S insert(S entity) {
		return lokerRepository.insert(entity);
	}

	@Override
	public Optional<LockerEntity> findById(String id) {
		return lokerRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return lokerRepository.existsById(id);
	}

	@Override
	public <S extends LockerEntity> List<S> insert(Iterable<S> entities) {
		return lokerRepository.insert(entities);
	}

	@Override
	public <S extends LockerEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return lokerRepository.findAll(example, pageable);
	}

	@Override
	public Iterable<LockerEntity> findAllById(Iterable<String> ids) {
		return lokerRepository.findAllById(ids);
	}

	@Override
	public <S extends LockerEntity> List<S> findAll(Example<S> example) {
		return lokerRepository.findAll(example);
	}

	@Override
	public <S extends LockerEntity> long count(Example<S> example) {
		return lokerRepository.count(example);
	}

	@Override
	public <S extends LockerEntity> boolean exists(Example<S> example) {
		return lokerRepository.exists(example);
	}

	@Override
	public long count() {
		return lokerRepository.count();
	}

	@Override
	public void deleteById(String id) {
		lokerRepository.deleteById(id);
	}

	@Override
	public void delete(LockerEntity entity) {
		lokerRepository.delete(entity);
	}

	@Override
	public <S extends LockerEntity> List<S> findAll(Example<S> example, Sort sort) {
		return lokerRepository.findAll(example, sort);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		lokerRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends LockerEntity> entities) {
		lokerRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lokerRepository.deleteAll();
	}
	
	
}
