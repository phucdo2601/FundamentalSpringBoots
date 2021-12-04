package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;
import com.phucdn.learnSpringSecurity.repository.EmployeeRepostiory;
import com.phucdn.learnSpringSecurity.service.EmployeeService;

@Service
public class EmployeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepostiory employeeRepostiory;

	@Override
	public <S extends EmployeeEntity> S save(S entity) {
		return employeeRepostiory.save(entity);
	}

	@Override
	public <S extends EmployeeEntity> Optional<S> findOne(Example<S> example) {
		return employeeRepostiory.findOne(example);
	}

	@Override
	public Page<EmployeeEntity> findAll(Pageable pageable) {
		return employeeRepostiory.findAll(pageable);
	}

	@Override
	public <S extends EmployeeEntity> List<S> saveAll(Iterable<S> entities) {
		return employeeRepostiory.saveAll(entities);
	}

	@Override
	public List<EmployeeEntity> findAll() {
		return employeeRepostiory.findAll();
	}

	@Override
	public List<EmployeeEntity> findAll(Sort sort) {
		return employeeRepostiory.findAll(sort);
	}

	@Override
	public <S extends EmployeeEntity> S insert(S entity) {
		return employeeRepostiory.insert(entity);
	}

	@Override
	public Optional<EmployeeEntity> findById(String id) {
		return employeeRepostiory.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return employeeRepostiory.existsById(id);
	}

	@Override
	public <S extends EmployeeEntity> List<S> insert(Iterable<S> entities) {
		return employeeRepostiory.insert(entities);
	}

	@Override
	public <S extends EmployeeEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return employeeRepostiory.findAll(example, pageable);
	}

	@Override
	public Iterable<EmployeeEntity> findAllById(Iterable<String> ids) {
		return employeeRepostiory.findAllById(ids);
	}

	@Override
	public <S extends EmployeeEntity> List<S> findAll(Example<S> example) {
		return employeeRepostiory.findAll(example);
	}

	@Override
	public <S extends EmployeeEntity> long count(Example<S> example) {
		return employeeRepostiory.count(example);
	}

	@Override
	public <S extends EmployeeEntity> boolean exists(Example<S> example) {
		return employeeRepostiory.exists(example);
	}

	@Override
	public long count() {
		return employeeRepostiory.count();
	}

	@Override
	public void deleteById(String id) {
		employeeRepostiory.deleteById(id);
	}

	@Override
	public void delete(EmployeeEntity entity) {
		employeeRepostiory.delete(entity);
	}

	@Override
	public <S extends EmployeeEntity> List<S> findAll(Example<S> example, Sort sort) {
		return employeeRepostiory.findAll(example, sort);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		employeeRepostiory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends EmployeeEntity> entities) {
		employeeRepostiory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		employeeRepostiory.deleteAll();
	}
	
	
}
