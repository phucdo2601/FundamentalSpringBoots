package com.phucdn.shoppingPage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.shoppingPage.entity.DiscountEntity;

public interface DiscountService {

	<S extends DiscountEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends DiscountEntity> List<S> findAll(Example<S> example);

	DiscountEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends DiscountEntity> entities);

	DiscountEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(DiscountEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<DiscountEntity> entities);

	<S extends DiscountEntity> boolean exists(Example<S> example);

	<S extends DiscountEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<DiscountEntity> entities);

	<S extends DiscountEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DiscountEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends DiscountEntity> S saveAndFlush(S entity);

	void flush();

	<S extends DiscountEntity> List<S> saveAll(Iterable<S> entities);

	Optional<DiscountEntity> findById(String id);

	List<DiscountEntity> findAllById(Iterable<String> ids);

	List<DiscountEntity> findAll(Sort sort);

	List<DiscountEntity> findAll();

	Page<DiscountEntity> findAll(Pageable pageable);

	<S extends DiscountEntity> Optional<S> findOne(Example<S> example);

	<S extends DiscountEntity> S save(S entity);

}
