package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.CategoryEntity;

public interface CategoryService {

	<S extends CategoryEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends CategoryEntity> List<S> findAll(Example<S> example);

	CategoryEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends CategoryEntity> entities);

	CategoryEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(CategoryEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<CategoryEntity> entities);

	<S extends CategoryEntity> boolean exists(Example<S> example);

	<S extends CategoryEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<CategoryEntity> entities);

	<S extends CategoryEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CategoryEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends CategoryEntity> S saveAndFlush(S entity);

	void flush();

	<S extends CategoryEntity> List<S> saveAll(Iterable<S> entities);

	Optional<CategoryEntity> findById(String id);

	List<CategoryEntity> findAllById(Iterable<String> ids);

	List<CategoryEntity> findAll(Sort sort);

	List<CategoryEntity> findAll();

	Page<CategoryEntity> findAll(Pageable pageable);

	<S extends CategoryEntity> Optional<S> findOne(Example<S> example);

	<S extends CategoryEntity> S save(S entity);

}
