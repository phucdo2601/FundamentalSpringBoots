package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.EmployeeDeparmentEntity;

public interface EmployeeDepartmentService {

	void deleteAll();

	void deleteAll(Iterable<? extends EmployeeDeparmentEntity> entities);

	void deleteAllById(Iterable<? extends String> ids);

	<S extends EmployeeDeparmentEntity> List<S> findAll(Example<S> example, Sort sort);

	void delete(EmployeeDeparmentEntity entity);

	void deleteById(String id);

	long count();

	<S extends EmployeeDeparmentEntity> boolean exists(Example<S> example);

	<S extends EmployeeDeparmentEntity> long count(Example<S> example);

	<S extends EmployeeDeparmentEntity> List<S> findAll(Example<S> example);

	Iterable<EmployeeDeparmentEntity> findAllById(Iterable<String> ids);

	<S extends EmployeeDeparmentEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends EmployeeDeparmentEntity> List<S> insert(Iterable<S> entities);

	boolean existsById(String id);

	Optional<EmployeeDeparmentEntity> findById(String id);

	<S extends EmployeeDeparmentEntity> S insert(S entity);

	List<EmployeeDeparmentEntity> findAll(Sort sort);

	List<EmployeeDeparmentEntity> findAll();

	<S extends EmployeeDeparmentEntity> List<S> saveAll(Iterable<S> entities);

	Page<EmployeeDeparmentEntity> findAll(Pageable pageable);

	<S extends EmployeeDeparmentEntity> Optional<S> findOne(Example<S> example);

	<S extends EmployeeDeparmentEntity> S save(S entity);

}
