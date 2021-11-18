package com.phucdn.shoppingPage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.shoppingPage.entity.UserEntity;
import com.phucdn.shoppingPage.repository.UserRepository;
import com.phucdn.shoppingPage.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public <S extends UserEntity> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
		return userRepository.findOne(example);
	}

	@Override
	public Page<UserEntity> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<UserEntity> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	@Override
	public List<UserEntity> findAllById(Iterable<String> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public Optional<UserEntity> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		userRepository.flush();
	}

	@Override
	public <S extends UserEntity> S saveAndFlush(S entity) {
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return userRepository.existsById(id);
	}

	@Override
	public <S extends UserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return userRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<UserEntity> entities) {
		userRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends UserEntity> long count(Example<S> example) {
		return userRepository.count(example);
	}

	@Override
	public <S extends UserEntity> boolean exists(Example<S> example) {
		return userRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<UserEntity> entities) {
		userRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		userRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(UserEntity entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		userRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	@Override
	public UserEntity getOne(String id) {
		return userRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends UserEntity> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public UserEntity getById(String id) {
		return userRepository.getById(id);
	}

	@Override
	public <S extends UserEntity> List<S> findAll(Example<S> example) {
		return userRepository.findAll(example);
	}

	@Override
	public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}
	
	
}
