package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.DiscountOfUserEntity;

public interface DiscountOfUserService {

	<S extends DiscountOfUserEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends DiscountOfUserEntity> List<S> findAll(Example<S> example);

	DiscountOfUserEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends DiscountOfUserEntity> entities);

	DiscountOfUserEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(DiscountOfUserEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<DiscountOfUserEntity> entities);

	<S extends DiscountOfUserEntity> boolean exists(Example<S> example);

	<S extends DiscountOfUserEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<DiscountOfUserEntity> entities);

	<S extends DiscountOfUserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DiscountOfUserEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends DiscountOfUserEntity> S saveAndFlush(S entity);

	void flush();

	<S extends DiscountOfUserEntity> List<S> saveAll(Iterable<S> entities);

	Optional<DiscountOfUserEntity> findById(String id);

	List<DiscountOfUserEntity> findAllById(Iterable<String> ids);

	List<DiscountOfUserEntity> findAll(Sort sort);

	List<DiscountOfUserEntity> findAll();

	Page<DiscountOfUserEntity> findAll(Pageable pageable);

	<S extends DiscountOfUserEntity> Optional<S> findOne(Example<S> example);

	<S extends DiscountOfUserEntity> S save(S entity);

}
