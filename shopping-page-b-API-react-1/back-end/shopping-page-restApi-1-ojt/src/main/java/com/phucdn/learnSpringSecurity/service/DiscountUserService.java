package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.DiscountUserEntity;

public interface DiscountUserService {

	<S extends DiscountUserEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends DiscountUserEntity> List<S> findAll(Example<S> example);

	DiscountUserEntity getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends DiscountUserEntity> entities);

	DiscountUserEntity getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(DiscountUserEntity entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<DiscountUserEntity> entities);

	<S extends DiscountUserEntity> boolean exists(Example<S> example);

	<S extends DiscountUserEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<DiscountUserEntity> entities);

	<S extends DiscountUserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DiscountUserEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends DiscountUserEntity> S saveAndFlush(S entity);

	void flush();

	<S extends DiscountUserEntity> List<S> saveAll(Iterable<S> entities);

	Optional<DiscountUserEntity> findById(Integer id);

	List<DiscountUserEntity> findAllById(Iterable<Integer> ids);

	List<DiscountUserEntity> findAll(Sort sort);

	List<DiscountUserEntity> findAll();

	Page<DiscountUserEntity> findAll(Pageable pageable);

	<S extends DiscountUserEntity> Optional<S> findOne(Example<S> example);

	<S extends DiscountUserEntity> S save(S entity);

}
