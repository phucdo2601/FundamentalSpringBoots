package com.phucdn.shoppingPage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.shoppingPage.entity.RoleUserEntity;
import com.phucdn.shoppingPage.repository.RoleUserRepository;
import com.phucdn.shoppingPage.service.RoleUserService;

@Service
public class RoleUserServiceImpl implements RoleUserService {
	@Autowired
	private RoleUserRepository roleUserRepository;

	@Override
	public <S extends RoleUserEntity> S save(S entity) {
		return roleUserRepository.save(entity);
	}

	@Override
	public <S extends RoleUserEntity> Optional<S> findOne(Example<S> example) {
		return roleUserRepository.findOne(example);
	}

	@Override
	public Page<RoleUserEntity> findAll(Pageable pageable) {
		return roleUserRepository.findAll(pageable);
	}

	@Override
	public List<RoleUserEntity> findAll() {
		return roleUserRepository.findAll();
	}

	@Override
	public List<RoleUserEntity> findAll(Sort sort) {
		return roleUserRepository.findAll(sort);
	}

	@Override
	public List<RoleUserEntity> findAllById(Iterable<String> ids) {
		return roleUserRepository.findAllById(ids);
	}

	@Override
	public Optional<RoleUserEntity> findById(String id) {
		return roleUserRepository.findById(id);
	}

	@Override
	public <S extends RoleUserEntity> List<S> saveAll(Iterable<S> entities) {
		return roleUserRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		roleUserRepository.flush();
	}

	@Override
	public <S extends RoleUserEntity> S saveAndFlush(S entity) {
		return roleUserRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return roleUserRepository.existsById(id);
	}

	@Override
	public <S extends RoleUserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return roleUserRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends RoleUserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleUserRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<RoleUserEntity> entities) {
		roleUserRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends RoleUserEntity> long count(Example<S> example) {
		return roleUserRepository.count(example);
	}

	@Override
	public <S extends RoleUserEntity> boolean exists(Example<S> example) {
		return roleUserRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<RoleUserEntity> entities) {
		roleUserRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return roleUserRepository.count();
	}

	@Override
	public void deleteById(String id) {
		roleUserRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		roleUserRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(RoleUserEntity entity) {
		roleUserRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		roleUserRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		roleUserRepository.deleteAllInBatch();
	}

	@Override
	public RoleUserEntity getOne(String id) {
		return roleUserRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends RoleUserEntity> entities) {
		roleUserRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		roleUserRepository.deleteAll();
	}

	@Override
	public RoleUserEntity getById(String id) {
		return roleUserRepository.getById(id);
	}

	@Override
	public <S extends RoleUserEntity> List<S> findAll(Example<S> example) {
		return roleUserRepository.findAll(example);
	}

	@Override
	public <S extends RoleUserEntity> List<S> findAll(Example<S> example, Sort sort) {
		return roleUserRepository.findAll(example, sort);
	}

	
}
