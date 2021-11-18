package com.phucdn.shoppingPage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.shoppingPage.entity.RoleUserEntity;

public interface RoleUserService {

	<S extends RoleUserEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends RoleUserEntity> List<S> findAll(Example<S> example);

	RoleUserEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends RoleUserEntity> entities);

	RoleUserEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(RoleUserEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<RoleUserEntity> entities);

	<S extends RoleUserEntity> boolean exists(Example<S> example);

	<S extends RoleUserEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<RoleUserEntity> entities);

	<S extends RoleUserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends RoleUserEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends RoleUserEntity> S saveAndFlush(S entity);

	void flush();

	<S extends RoleUserEntity> List<S> saveAll(Iterable<S> entities);

	Optional<RoleUserEntity> findById(String id);

	List<RoleUserEntity> findAllById(Iterable<String> ids);

	List<RoleUserEntity> findAll(Sort sort);

	List<RoleUserEntity> findAll();

	Page<RoleUserEntity> findAll(Pageable pageable);

	<S extends RoleUserEntity> Optional<S> findOne(Example<S> example);

	<S extends RoleUserEntity> S save(S entity);

}
