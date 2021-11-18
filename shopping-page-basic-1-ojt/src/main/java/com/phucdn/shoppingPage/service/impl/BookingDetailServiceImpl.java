package com.phucdn.shoppingPage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.shoppingPage.entity.BookingDetailEntity;
import com.phucdn.shoppingPage.repository.BookingDetailRepository;
import com.phucdn.shoppingPage.service.BookingDetailService;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {
	
	@Autowired
	private BookingDetailRepository bookingDetailRepository;

	@Override
	public <S extends BookingDetailEntity> S save(S entity) {
		return bookingDetailRepository.save(entity);
	}

	@Override
	public <S extends BookingDetailEntity> Optional<S> findOne(Example<S> example) {
		return bookingDetailRepository.findOne(example);
	}

	@Override
	public Page<BookingDetailEntity> findAll(Pageable pageable) {
		return bookingDetailRepository.findAll(pageable);
	}

	@Override
	public List<BookingDetailEntity> findAll() {
		return bookingDetailRepository.findAll();
	}

	@Override
	public List<BookingDetailEntity> findAll(Sort sort) {
		return bookingDetailRepository.findAll(sort);
	}

	@Override
	public List<BookingDetailEntity> findAllById(Iterable<String> ids) {
		return bookingDetailRepository.findAllById(ids);
	}

	@Override
	public Optional<BookingDetailEntity> findById(String id) {
		return bookingDetailRepository.findById(id);
	}

	@Override
	public <S extends BookingDetailEntity> List<S> saveAll(Iterable<S> entities) {
		return bookingDetailRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		bookingDetailRepository.flush();
	}

	@Override
	public <S extends BookingDetailEntity> S saveAndFlush(S entity) {
		return bookingDetailRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return bookingDetailRepository.existsById(id);
	}

	@Override
	public <S extends BookingDetailEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return bookingDetailRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends BookingDetailEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return bookingDetailRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<BookingDetailEntity> entities) {
		bookingDetailRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends BookingDetailEntity> long count(Example<S> example) {
		return bookingDetailRepository.count(example);
	}

	@Override
	public <S extends BookingDetailEntity> boolean exists(Example<S> example) {
		return bookingDetailRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<BookingDetailEntity> entities) {
		bookingDetailRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return bookingDetailRepository.count();
	}

	@Override
	public void deleteById(String id) {
		bookingDetailRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		bookingDetailRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(BookingDetailEntity entity) {
		bookingDetailRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		bookingDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		bookingDetailRepository.deleteAllInBatch();
	}

	@Override
	public BookingDetailEntity getOne(String id) {
		return bookingDetailRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends BookingDetailEntity> entities) {
		bookingDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bookingDetailRepository.deleteAll();
	}

	@Override
	public BookingDetailEntity getById(String id) {
		return bookingDetailRepository.getById(id);
	}

	@Override
	public <S extends BookingDetailEntity> List<S> findAll(Example<S> example) {
		return bookingDetailRepository.findAll(example);
	}

	@Override
	public <S extends BookingDetailEntity> List<S> findAll(Example<S> example, Sort sort) {
		return bookingDetailRepository.findAll(example, sort);
	}

	
}
