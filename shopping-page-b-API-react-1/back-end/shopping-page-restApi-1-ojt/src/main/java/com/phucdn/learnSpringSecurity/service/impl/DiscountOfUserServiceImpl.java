package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.DiscountOfUserEntity;
import com.phucdn.learnSpringSecurity.repository.DiscountOfUserRepository;
import com.phucdn.learnSpringSecurity.service.DiscountOfUserService;

@Service
public class DiscountOfUserServiceImpl implements DiscountOfUserService{

	@Autowired
	private DiscountOfUserRepository discountOfUserRepository;

	@Override
	public <S extends DiscountOfUserEntity> S save(S entity) {
		return discountOfUserRepository.save(entity);
	}

	@Override
	public <S extends DiscountOfUserEntity> Optional<S> findOne(Example<S> example) {
		return discountOfUserRepository.findOne(example);
	}

	@Override
	public Page<DiscountOfUserEntity> findAll(Pageable pageable) {
		return discountOfUserRepository.findAll(pageable);
	}

	@Override
	public List<DiscountOfUserEntity> findAll() {
		return discountOfUserRepository.findAll();
	}

	@Override
	public List<DiscountOfUserEntity> findAll(Sort sort) {
		return discountOfUserRepository.findAll(sort);
	}

	@Override
	public List<DiscountOfUserEntity> findAllById(Iterable<String> ids) {
		return discountOfUserRepository.findAllById(ids);
	}

	@Override
	public Optional<DiscountOfUserEntity> findById(String id) {
		return discountOfUserRepository.findById(id);
	}

	@Override
	public <S extends DiscountOfUserEntity> List<S> saveAll(Iterable<S> entities) {
		return discountOfUserRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		discountOfUserRepository.flush();
	}

	@Override
	public <S extends DiscountOfUserEntity> S saveAndFlush(S entity) {
		return discountOfUserRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return discountOfUserRepository.existsById(id);
	}

	@Override
	public <S extends DiscountOfUserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return discountOfUserRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends DiscountOfUserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return discountOfUserRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<DiscountOfUserEntity> entities) {
		discountOfUserRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends DiscountOfUserEntity> long count(Example<S> example) {
		return discountOfUserRepository.count(example);
	}

	@Override
	public <S extends DiscountOfUserEntity> boolean exists(Example<S> example) {
		return discountOfUserRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<DiscountOfUserEntity> entities) {
		discountOfUserRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return discountOfUserRepository.count();
	}

	@Override
	public void deleteById(String id) {
		discountOfUserRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		discountOfUserRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(DiscountOfUserEntity entity) {
		discountOfUserRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		discountOfUserRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		discountOfUserRepository.deleteAllInBatch();
	}

	@Override
	public DiscountOfUserEntity getOne(String id) {
		return discountOfUserRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends DiscountOfUserEntity> entities) {
		discountOfUserRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		discountOfUserRepository.deleteAll();
	}

	@Override
	public DiscountOfUserEntity getById(String id) {
		return discountOfUserRepository.getById(id);
	}

	@Override
	public <S extends DiscountOfUserEntity> List<S> findAll(Example<S> example) {
		return discountOfUserRepository.findAll(example);
	}

	@Override
	public <S extends DiscountOfUserEntity> List<S> findAll(Example<S> example, Sort sort) {
		return discountOfUserRepository.findAll(example, sort);
	}
	
	
}
