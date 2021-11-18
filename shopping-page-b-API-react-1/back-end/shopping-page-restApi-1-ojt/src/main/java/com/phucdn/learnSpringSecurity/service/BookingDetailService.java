package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.BookingDetailEntity;

public interface BookingDetailService {

	<S extends BookingDetailEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends BookingDetailEntity> List<S> findAll(Example<S> example);

	BookingDetailEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends BookingDetailEntity> entities);

	BookingDetailEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(BookingDetailEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<BookingDetailEntity> entities);

	<S extends BookingDetailEntity> boolean exists(Example<S> example);

	<S extends BookingDetailEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<BookingDetailEntity> entities);

	<S extends BookingDetailEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends BookingDetailEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends BookingDetailEntity> S saveAndFlush(S entity);

	void flush();

	<S extends BookingDetailEntity> List<S> saveAll(Iterable<S> entities);

	Optional<BookingDetailEntity> findById(String id);

	List<BookingDetailEntity> findAllById(Iterable<String> ids);

	List<BookingDetailEntity> findAll(Sort sort);

	List<BookingDetailEntity> findAll();

	Page<BookingDetailEntity> findAll(Pageable pageable);

	<S extends BookingDetailEntity> Optional<S> findOne(Example<S> example);

	<S extends BookingDetailEntity> S save(S entity);

}
