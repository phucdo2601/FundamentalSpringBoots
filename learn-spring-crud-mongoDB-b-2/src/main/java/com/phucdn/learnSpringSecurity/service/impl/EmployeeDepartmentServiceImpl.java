package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.EmployeeDeparmentEntity;
import com.phucdn.learnSpringSecurity.repository.EmployeeDeparmentRepository;
import com.phucdn.learnSpringSecurity.service.EmployeeDepartmentService;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {

	@Autowired
	private EmployeeDeparmentRepository employeeDeparmentRepository;

	@Override
	public <S extends EmployeeDeparmentEntity> S save(S entity) {
		return employeeDeparmentRepository.save(entity);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> Optional<S> findOne(Example<S> example) {
		return employeeDeparmentRepository.findOne(example);
	}

	@Override
	public Page<EmployeeDeparmentEntity> findAll(Pageable pageable) {
		return employeeDeparmentRepository.findAll(pageable);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> List<S> saveAll(Iterable<S> entities) {
		return employeeDeparmentRepository.saveAll(entities);
	}

	@Override
	public List<EmployeeDeparmentEntity> findAll() {
		return employeeDeparmentRepository.findAll();
	}

	@Override
	public List<EmployeeDeparmentEntity> findAll(Sort sort) {
		return employeeDeparmentRepository.findAll(sort);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> S insert(S entity) {
		return employeeDeparmentRepository.insert(entity);
	}

	@Override
	public Optional<EmployeeDeparmentEntity> findById(String id) {
		return employeeDeparmentRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return employeeDeparmentRepository.existsById(id);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> List<S> insert(Iterable<S> entities) {
		return employeeDeparmentRepository.insert(entities);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return employeeDeparmentRepository.findAll(example, pageable);
	}

	@Override
	public Iterable<EmployeeDeparmentEntity> findAllById(Iterable<String> ids) {
		return employeeDeparmentRepository.findAllById(ids);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> List<S> findAll(Example<S> example) {
		return employeeDeparmentRepository.findAll(example);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> long count(Example<S> example) {
		return employeeDeparmentRepository.count(example);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> boolean exists(Example<S> example) {
		return employeeDeparmentRepository.exists(example);
	}

	@Override
	public long count() {
		return employeeDeparmentRepository.count();
	}

	@Override
	public void deleteById(String id) {
		employeeDeparmentRepository.deleteById(id);
	}

	@Override
	public void delete(EmployeeDeparmentEntity entity) {
		employeeDeparmentRepository.delete(entity);
	}

	@Override
	public <S extends EmployeeDeparmentEntity> List<S> findAll(Example<S> example, Sort sort) {
		return employeeDeparmentRepository.findAll(example, sort);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		employeeDeparmentRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends EmployeeDeparmentEntity> entities) {
		employeeDeparmentRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		employeeDeparmentRepository.deleteAll();
	}

	
}
