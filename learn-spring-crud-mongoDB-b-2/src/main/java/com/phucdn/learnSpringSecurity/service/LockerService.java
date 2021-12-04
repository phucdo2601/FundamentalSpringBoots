package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.LockerEntity;

public interface LockerService {

	void deleteAll();

	void deleteAll(Iterable<? extends LockerEntity> entities);

	void deleteAllById(Iterable<? extends String> ids);

	<S extends LockerEntity> List<S> findAll(Example<S> example, Sort sort);

	void delete(LockerEntity entity);

	void deleteById(String id);

	long count();

	<S extends LockerEntity> boolean exists(Example<S> example);

	<S extends LockerEntity> long count(Example<S> example);

	<S extends LockerEntity> List<S> findAll(Example<S> example);

	Iterable<LockerEntity> findAllById(Iterable<String> ids);

	<S extends LockerEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends LockerEntity> List<S> insert(Iterable<S> entities);

	boolean existsById(String id);

	Optional<LockerEntity> findById(String id);

	<S extends LockerEntity> S insert(S entity);

	List<LockerEntity> findAll(Sort sort);

	List<LockerEntity> findAll();

	<S extends LockerEntity> List<S> saveAll(Iterable<S> entities);

	Page<LockerEntity> findAll(Pageable pageable);

	<S extends LockerEntity> Optional<S> findOne(Example<S> example);

	<S extends LockerEntity> S save(S entity);

}
