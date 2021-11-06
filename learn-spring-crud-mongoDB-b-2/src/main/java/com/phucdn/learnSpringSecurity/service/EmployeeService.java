package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;

public interface EmployeeService {

	void deleteAll();

	void deleteAll(Iterable<? extends EmployeeEntity> entities);

	void deleteAllById(Iterable<? extends String> ids);

	<S extends EmployeeEntity> List<S> findAll(Example<S> example, Sort sort);

	void delete(EmployeeEntity entity);

	void deleteById(String id);

	long count();

	<S extends EmployeeEntity> boolean exists(Example<S> example);

	<S extends EmployeeEntity> long count(Example<S> example);

	<S extends EmployeeEntity> List<S> findAll(Example<S> example);

	Iterable<EmployeeEntity> findAllById(Iterable<String> ids);

	<S extends EmployeeEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends EmployeeEntity> List<S> insert(Iterable<S> entities);

	boolean existsById(String id);

	Optional<EmployeeEntity> findById(String id);

	<S extends EmployeeEntity> S insert(S entity);

	List<EmployeeEntity> findAll(Sort sort);

	List<EmployeeEntity> findAll();

	<S extends EmployeeEntity> List<S> saveAll(Iterable<S> entities);

	Page<EmployeeEntity> findAll(Pageable pageable);

	<S extends EmployeeEntity> Optional<S> findOne(Example<S> example);

	<S extends EmployeeEntity> S save(S entity);

}
