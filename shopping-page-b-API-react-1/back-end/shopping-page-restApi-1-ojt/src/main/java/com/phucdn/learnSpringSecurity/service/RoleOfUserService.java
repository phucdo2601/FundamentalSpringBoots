package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.RoleOfUserEntity;

public interface RoleOfUserService {

	<S extends RoleOfUserEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends RoleOfUserEntity> List<S> findAll(Example<S> example);

	RoleOfUserEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends RoleOfUserEntity> entities);

	RoleOfUserEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(RoleOfUserEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<RoleOfUserEntity> entities);

	<S extends RoleOfUserEntity> boolean exists(Example<S> example);

	<S extends RoleOfUserEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<RoleOfUserEntity> entities);

	<S extends RoleOfUserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends RoleOfUserEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends RoleOfUserEntity> S saveAndFlush(S entity);

	void flush();

	<S extends RoleOfUserEntity> List<S> saveAll(Iterable<S> entities);

	Optional<RoleOfUserEntity> findById(String id);

	List<RoleOfUserEntity> findAllById(Iterable<String> ids);

	List<RoleOfUserEntity> findAll(Sort sort);

	List<RoleOfUserEntity> findAll();

	Page<RoleOfUserEntity> findAll(Pageable pageable);

	<S extends RoleOfUserEntity> Optional<S> findOne(Example<S> example);

	<S extends RoleOfUserEntity> S save(S entity);

}
