package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.phucdn.learnSpringSecurity.entity.DepartmentEntity;
import com.phucdn.learnSpringSecurity.repository.DepartmentRepository;
import com.phucdn.learnSpringSecurity.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends DepartmentEntity> S save(S entity) {
		return departmentRepository.save(entity);
	}

	@Override
	public <S extends DepartmentEntity> Optional<S> findOne(Example<S> example) {
		return departmentRepository.findOne(example);
	}

	@Override
	public Page<DepartmentEntity> findAll(Pageable pageable) {
		return departmentRepository.findAll(pageable);
	}

	@Override
	public <S extends DepartmentEntity> List<S> saveAll(Iterable<S> entities) {
		return departmentRepository.saveAll(entities);
	}

	@Override
	public List<DepartmentEntity> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public List<DepartmentEntity> findAll(Sort sort) {
		return departmentRepository.findAll(sort);
	}

	@Override
	public <S extends DepartmentEntity> S insert(S entity) {
		return departmentRepository.insert(entity);
	}

	@Override
	public Optional<DepartmentEntity> findById(String id) {
		return departmentRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return departmentRepository.existsById(id);
	}

	@Override
	public <S extends DepartmentEntity> List<S> insert(Iterable<S> entities) {
		return departmentRepository.insert(entities);
	}

	@Override
	public <S extends DepartmentEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return departmentRepository.findAll(example, pageable);
	}

	@Override
	public Iterable<DepartmentEntity> findAllById(Iterable<String> ids) {
		return departmentRepository.findAllById(ids);
	}

	@Override
	public <S extends DepartmentEntity> List<S> findAll(Example<S> example) {
		return departmentRepository.findAll(example);
	}

	@Override
	public <S extends DepartmentEntity> long count(Example<S> example) {
		return departmentRepository.count(example);
	}

	@Override
	public <S extends DepartmentEntity> boolean exists(Example<S> example) {
		return departmentRepository.exists(example);
	}

	@Override
	public long count() {
		return departmentRepository.count();
	}

	@Override
	public void deleteById(String id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public void delete(DepartmentEntity entity) {
		departmentRepository.delete(entity);
	}

	@Override
	public <S extends DepartmentEntity> List<S> findAll(Example<S> example, Sort sort) {
		return departmentRepository.findAll(example, sort);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		departmentRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends DepartmentEntity> entities) {
		departmentRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		departmentRepository.deleteAll();
	}
	
	
	@Override
	public Optional<DepartmentEntity> changeStatusOfDepartment(String depId, String status) {
		Query query = new Query(Criteria.where("depId").is(depId));
		Update update = new Update();
		update.set("status", status);
		
		UpdateResult result = this.mongoTemplate.updateFirst(query, update, DepartmentEntity.class);
		if (result != null) {
			return departmentRepository.findByDepId(depId);
		}
		return null;
	}
}
