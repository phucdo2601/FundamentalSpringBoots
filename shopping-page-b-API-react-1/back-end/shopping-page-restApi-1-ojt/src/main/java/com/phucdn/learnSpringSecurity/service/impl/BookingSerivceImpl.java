package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.BookingEntity;
import com.phucdn.learnSpringSecurity.repository.BookingRepository;
import com.phucdn.learnSpringSecurity.service.BookingSerivce;

@Service
public class BookingSerivceImpl implements BookingSerivce {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public <S extends BookingEntity> S save(S entity) {
		return bookingRepository.save(entity);
	}

	@Override
	public <S extends BookingEntity> Optional<S> findOne(Example<S> example) {
		return bookingRepository.findOne(example);
	}

	@Override
	public Page<BookingEntity> findAll(Pageable pageable) {
		return bookingRepository.findAll(pageable);
	}

	@Override
	public List<BookingEntity> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public List<BookingEntity> findAll(Sort sort) {
		return bookingRepository.findAll(sort);
	}

	@Override
	public List<BookingEntity> findAllById(Iterable<String> ids) {
		return bookingRepository.findAllById(ids);
	}

	@Override
	public Optional<BookingEntity> findById(String id) {
		return bookingRepository.findById(id);
	}

	@Override
	public <S extends BookingEntity> List<S> saveAll(Iterable<S> entities) {
		return bookingRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		bookingRepository.flush();
	}

	@Override
	public <S extends BookingEntity> S saveAndFlush(S entity) {
		return bookingRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return bookingRepository.existsById(id);
	}

	@Override
	public <S extends BookingEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return bookingRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends BookingEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return bookingRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<BookingEntity> entities) {
		bookingRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends BookingEntity> long count(Example<S> example) {
		return bookingRepository.count(example);
	}

	@Override
	public <S extends BookingEntity> boolean exists(Example<S> example) {
		return bookingRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<BookingEntity> entities) {
		bookingRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return bookingRepository.count();
	}

	@Override
	public void deleteById(String id) {
		bookingRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		bookingRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(BookingEntity entity) {
		bookingRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		bookingRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		bookingRepository.deleteAllInBatch();
	}

	@Override
	public BookingEntity getOne(String id) {
		return bookingRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends BookingEntity> entities) {
		bookingRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bookingRepository.deleteAll();
	}

	@Override
	public BookingEntity getById(String id) {
		return bookingRepository.getById(id);
	}

	@Override
	public <S extends BookingEntity> List<S> findAll(Example<S> example) {
		return bookingRepository.findAll(example);
	}

	@Override
	public <S extends BookingEntity> List<S> findAll(Example<S> example, Sort sort) {
		return bookingRepository.findAll(example, sort);
	}
	
}
