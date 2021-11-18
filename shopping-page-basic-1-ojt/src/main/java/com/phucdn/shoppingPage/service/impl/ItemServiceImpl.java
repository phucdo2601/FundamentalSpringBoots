package com.phucdn.shoppingPage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.shoppingPage.entity.ItemEntity;
import com.phucdn.shoppingPage.repository.ItemRepository;
import com.phucdn.shoppingPage.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public <S extends ItemEntity> S save(S entity) {
		return itemRepository.save(entity);
	}

	@Override
	public <S extends ItemEntity> Optional<S> findOne(Example<S> example) {
		return itemRepository.findOne(example);
	}

	@Override
	public Page<ItemEntity> findAll(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}

	@Override
	public List<ItemEntity> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public List<ItemEntity> findAll(Sort sort) {
		return itemRepository.findAll(sort);
	}

	@Override
	public List<ItemEntity> findAllById(Iterable<String> ids) {
		return itemRepository.findAllById(ids);
	}

	@Override
	public Optional<ItemEntity> findById(String id) {
		return itemRepository.findById(id);
	}

	@Override
	public <S extends ItemEntity> List<S> saveAll(Iterable<S> entities) {
		return itemRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		itemRepository.flush();
	}

	@Override
	public <S extends ItemEntity> S saveAndFlush(S entity) {
		return itemRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return itemRepository.existsById(id);
	}

	@Override
	public <S extends ItemEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return itemRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ItemEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return itemRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ItemEntity> entities) {
		itemRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ItemEntity> long count(Example<S> example) {
		return itemRepository.count(example);
	}

	@Override
	public <S extends ItemEntity> boolean exists(Example<S> example) {
		return itemRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ItemEntity> entities) {
		itemRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return itemRepository.count();
	}

	@Override
	public void deleteById(String id) {
		itemRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		itemRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ItemEntity entity) {
		itemRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		itemRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		itemRepository.deleteAllInBatch();
	}

	@Override
	public ItemEntity getOne(String id) {
		return itemRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ItemEntity> entities) {
		itemRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		itemRepository.deleteAll();
	}

	@Override
	public ItemEntity getById(String id) {
		return itemRepository.getById(id);
	}

	@Override
	public <S extends ItemEntity> List<S> findAll(Example<S> example) {
		return itemRepository.findAll(example);
	}

	@Override
	public <S extends ItemEntity> List<S> findAll(Example<S> example, Sort sort) {
		return itemRepository.findAll(example, sort);
	}
	
}
