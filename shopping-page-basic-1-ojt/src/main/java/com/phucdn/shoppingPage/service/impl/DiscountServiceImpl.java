package com.phucdn.shoppingPage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.shoppingPage.entity.DiscountEntity;
import com.phucdn.shoppingPage.repository.DiscountRepository;
import com.phucdn.shoppingPage.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public <S extends DiscountEntity> S save(S entity) {
		return discountRepository.save(entity);
	}

	@Override
	public <S extends DiscountEntity> Optional<S> findOne(Example<S> example) {
		return discountRepository.findOne(example);
	}

	@Override
	public Page<DiscountEntity> findAll(Pageable pageable) {
		return discountRepository.findAll(pageable);
	}

	@Override
	public List<DiscountEntity> findAll() {
		return discountRepository.findAll();
	}

	@Override
	public List<DiscountEntity> findAll(Sort sort) {
		return discountRepository.findAll(sort);
	}

	@Override
	public List<DiscountEntity> findAllById(Iterable<String> ids) {
		return discountRepository.findAllById(ids);
	}

	@Override
	public Optional<DiscountEntity> findById(String id) {
		return discountRepository.findById(id);
	}

	@Override
	public <S extends DiscountEntity> List<S> saveAll(Iterable<S> entities) {
		return discountRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		discountRepository.flush();
	}

	@Override
	public <S extends DiscountEntity> S saveAndFlush(S entity) {
		return discountRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return discountRepository.existsById(id);
	}

	@Override
	public <S extends DiscountEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return discountRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends DiscountEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return discountRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<DiscountEntity> entities) {
		discountRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends DiscountEntity> long count(Example<S> example) {
		return discountRepository.count(example);
	}

	@Override
	public <S extends DiscountEntity> boolean exists(Example<S> example) {
		return discountRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<DiscountEntity> entities) {
		discountRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return discountRepository.count();
	}

	@Override
	public void deleteById(String id) {
		discountRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		discountRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(DiscountEntity entity) {
		discountRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		discountRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		discountRepository.deleteAllInBatch();
	}

	@Override
	public DiscountEntity getOne(String id) {
		return discountRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends DiscountEntity> entities) {
		discountRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		discountRepository.deleteAll();
	}

	@Override
	public DiscountEntity getById(String id) {
		return discountRepository.getById(id);
	}

	@Override
	public <S extends DiscountEntity> List<S> findAll(Example<S> example) {
		return discountRepository.findAll(example);
	}

	@Override
	public <S extends DiscountEntity> List<S> findAll(Example<S> example, Sort sort) {
		return discountRepository.findAll(example, sort);
	}
	
	
}
