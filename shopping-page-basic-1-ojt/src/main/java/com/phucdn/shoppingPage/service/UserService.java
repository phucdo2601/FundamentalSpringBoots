package com.phucdn.shoppingPage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.shoppingPage.entity.UserEntity;

public interface UserService {

	<S extends UserEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends UserEntity> List<S> findAll(Example<S> example);

	UserEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends UserEntity> entities);

	UserEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(UserEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<UserEntity> entities);

	<S extends UserEntity> boolean exists(Example<S> example);

	<S extends UserEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<UserEntity> entities);

	<S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends UserEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends UserEntity> S saveAndFlush(S entity);

	void flush();

	<S extends UserEntity> List<S> saveAll(Iterable<S> entities);

	Optional<UserEntity> findById(String id);

	List<UserEntity> findAllById(Iterable<String> ids);

	List<UserEntity> findAll(Sort sort);

	List<UserEntity> findAll();

	Page<UserEntity> findAll(Pageable pageable);

	<S extends UserEntity> Optional<S> findOne(Example<S> example);

	<S extends UserEntity> S save(S entity);

}
