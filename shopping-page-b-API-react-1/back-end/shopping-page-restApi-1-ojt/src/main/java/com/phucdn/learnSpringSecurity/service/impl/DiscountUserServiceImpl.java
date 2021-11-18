package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.DiscountUserEntity;
import com.phucdn.learnSpringSecurity.repository.DiscountUserRepository;
import com.phucdn.learnSpringSecurity.service.DiscountUserService;

@Service
public class DiscountUserServiceImpl implements DiscountUserService{

	@Autowired
	private DiscountUserRepository discountUserRepository;

	@Override
	public <S extends DiscountUserEntity> S save(S entity) {
		return discountUserRepository.save(entity);
	}

	@Override
	public <S extends DiscountUserEntity> Optional<S> findOne(Example<S> example) {
		return discountUserRepository.findOne(example);
	}

	@Override
	public Page<DiscountUserEntity> findAll(Pageable pageable) {
		return discountUserRepository.findAll(pageable);
	}

	@Override
	public List<DiscountUserEntity> findAll() {
		return discountUserRepository.findAll();
	}

	@Override
	public List<DiscountUserEntity> findAll(Sort sort) {
		return discountUserRepository.findAll(sort);
	}

	@Override
	public List<DiscountUserEntity> findAllById(Iterable<Integer> ids) {
		return discountUserRepository.findAllById(ids);
	}

	@Override
	public Optional<DiscountUserEntity> findById(Integer id) {
		return discountUserRepository.findById(id);
	}

	@Override
	public <S extends DiscountUserEntity> List<S> saveAll(Iterable<S> entities) {
		return discountUserRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		discountUserRepository.flush();
	}

	@Override
	public <S extends DiscountUserEntity> S saveAndFlush(S entity) {
		return discountUserRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return discountUserRepository.existsById(id);
	}

	@Override
	public <S extends DiscountUserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return discountUserRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends DiscountUserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return discountUserRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<DiscountUserEntity> entities) {
		discountUserRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends DiscountUserEntity> long count(Example<S> example) {
		return discountUserRepository.count(example);
	}

	@Override
	public <S extends DiscountUserEntity> boolean exists(Example<S> example) {
		return discountUserRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<DiscountUserEntity> entities) {
		discountUserRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return discountUserRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		discountUserRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		discountUserRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(DiscountUserEntity entity) {
		discountUserRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		discountUserRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		discountUserRepository.deleteAllInBatch();
	}

	@Override
	public DiscountUserEntity getOne(Integer id) {
		return discountUserRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends DiscountUserEntity> entities) {
		discountUserRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		discountUserRepository.deleteAll();
	}

	@Override
	public DiscountUserEntity getById(Integer id) {
		return discountUserRepository.getById(id);
	}

	@Override
	public <S extends DiscountUserEntity> List<S> findAll(Example<S> example) {
		return discountUserRepository.findAll(example);
	}

	@Override
	public <S extends DiscountUserEntity> List<S> findAll(Example<S> example, Sort sort) {
		return discountUserRepository.findAll(example, sort);
	}
	
	
}
