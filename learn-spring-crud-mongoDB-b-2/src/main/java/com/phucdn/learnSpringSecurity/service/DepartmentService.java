package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.DepartmentEntity;

public interface DepartmentService {

	void deleteAll();

	void deleteAll(Iterable<? extends DepartmentEntity> entities);

	void deleteAllById(Iterable<? extends String> ids);

	<S extends DepartmentEntity> List<S> findAll(Example<S> example, Sort sort);

	void delete(DepartmentEntity entity);

	void deleteById(String id);

	long count();

	<S extends DepartmentEntity> boolean exists(Example<S> example);

	<S extends DepartmentEntity> long count(Example<S> example);

	<S extends DepartmentEntity> List<S> findAll(Example<S> example);

	Iterable<DepartmentEntity> findAllById(Iterable<String> ids);

	<S extends DepartmentEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DepartmentEntity> List<S> insert(Iterable<S> entities);

	boolean existsById(String id);

	Optional<DepartmentEntity> findById(String id);

	<S extends DepartmentEntity> S insert(S entity);

	List<DepartmentEntity> findAll(Sort sort);

	List<DepartmentEntity> findAll();

	<S extends DepartmentEntity> List<S> saveAll(Iterable<S> entities);

	Page<DepartmentEntity> findAll(Pageable pageable);

	<S extends DepartmentEntity> Optional<S> findOne(Example<S> example);

	<S extends DepartmentEntity> S save(S entity);

	List<DepartmentEntity> getAllDepartmentWithActivateStatus();

	Optional<DepartmentEntity> findByDepId(String depId);

	Optional<DepartmentEntity> changeStatusOfDepartment(String depId, String status);

}
