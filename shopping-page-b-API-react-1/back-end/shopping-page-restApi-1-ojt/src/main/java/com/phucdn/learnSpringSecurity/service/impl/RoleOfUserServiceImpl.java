package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.RoleOfUserEntity;
import com.phucdn.learnSpringSecurity.repository.RoleOfUserRepository;
import com.phucdn.learnSpringSecurity.service.RoleOfUserService;

@Service
public class RoleOfUserServiceImpl implements RoleOfUserService{
	@Autowired
	private RoleOfUserRepository roleOfUserRepository;

	@Override
	public <S extends RoleOfUserEntity> S save(S entity) {
		return roleOfUserRepository.save(entity);
	}

	@Override
	public <S extends RoleOfUserEntity> Optional<S> findOne(Example<S> example) {
		return roleOfUserRepository.findOne(example);
	}

	@Override
	public Page<RoleOfUserEntity> findAll(Pageable pageable) {
		return roleOfUserRepository.findAll(pageable);
	}

	@Override
	public List<RoleOfUserEntity> findAll() {
		return roleOfUserRepository.findAll();
	}

	@Override
	public List<RoleOfUserEntity> findAll(Sort sort) {
		return roleOfUserRepository.findAll(sort);
	}

	@Override
	public List<RoleOfUserEntity> findAllById(Iterable<String> ids) {
		return roleOfUserRepository.findAllById(ids);
	}

	@Override
	public Optional<RoleOfUserEntity> findById(String id) {
		return roleOfUserRepository.findById(id);
	}

	@Override
	public <S extends RoleOfUserEntity> List<S> saveAll(Iterable<S> entities) {
		return roleOfUserRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		roleOfUserRepository.flush();
	}

	@Override
	public <S extends RoleOfUserEntity> S saveAndFlush(S entity) {
		return roleOfUserRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return roleOfUserRepository.existsById(id);
	}

	@Override
	public <S extends RoleOfUserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return roleOfUserRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends RoleOfUserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleOfUserRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<RoleOfUserEntity> entities) {
		roleOfUserRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends RoleOfUserEntity> long count(Example<S> example) {
		return roleOfUserRepository.count(example);
	}

	@Override
	public <S extends RoleOfUserEntity> boolean exists(Example<S> example) {
		return roleOfUserRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<RoleOfUserEntity> entities) {
		roleOfUserRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return roleOfUserRepository.count();
	}

	@Override
	public void deleteById(String id) {
		roleOfUserRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		roleOfUserRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(RoleOfUserEntity entity) {
		roleOfUserRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		roleOfUserRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		roleOfUserRepository.deleteAllInBatch();
	}

	@Override
	public RoleOfUserEntity getOne(String id) {
		return roleOfUserRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends RoleOfUserEntity> entities) {
		roleOfUserRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		roleOfUserRepository.deleteAll();
	}

	@Override
	public RoleOfUserEntity getById(String id) {
		return roleOfUserRepository.getById(id);
	}

	@Override
	public <S extends RoleOfUserEntity> List<S> findAll(Example<S> example) {
		return roleOfUserRepository.findAll(example);
	}

	@Override
	public <S extends RoleOfUserEntity> List<S> findAll(Example<S> example, Sort sort) {
		return roleOfUserRepository.findAll(example, sort);
	}
	
	
}
