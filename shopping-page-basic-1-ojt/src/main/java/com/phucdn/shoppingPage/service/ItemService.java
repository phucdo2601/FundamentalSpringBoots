package com.phucdn.shoppingPage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.shoppingPage.entity.ItemEntity;

public interface ItemService {

	<S extends ItemEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends ItemEntity> List<S> findAll(Example<S> example);

	ItemEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends ItemEntity> entities);

	ItemEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(ItemEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<ItemEntity> entities);

	<S extends ItemEntity> boolean exists(Example<S> example);

	<S extends ItemEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<ItemEntity> entities);

	<S extends ItemEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ItemEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends ItemEntity> S saveAndFlush(S entity);

	void flush();

	<S extends ItemEntity> List<S> saveAll(Iterable<S> entities);

	Optional<ItemEntity> findById(String id);

	List<ItemEntity> findAllById(Iterable<String> ids);

	List<ItemEntity> findAll(Sort sort);

	List<ItemEntity> findAll();

	Page<ItemEntity> findAll(Pageable pageable);

	<S extends ItemEntity> Optional<S> findOne(Example<S> example);

	<S extends ItemEntity> S save(S entity);

	

}
