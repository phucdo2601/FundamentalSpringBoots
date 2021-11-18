package com.phucdn.shoppingPage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.shoppingPage.entity.BookingEntity;

public interface BookingService {

	<S extends BookingEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends BookingEntity> List<S> findAll(Example<S> example);

	BookingEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends BookingEntity> entities);

	BookingEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(BookingEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<BookingEntity> entities);

	<S extends BookingEntity> boolean exists(Example<S> example);

	<S extends BookingEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<BookingEntity> entities);

	<S extends BookingEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends BookingEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends BookingEntity> S saveAndFlush(S entity);

	void flush();

	<S extends BookingEntity> List<S> saveAll(Iterable<S> entities);

	Optional<BookingEntity> findById(String id);

	List<BookingEntity> findAllById(Iterable<String> ids);

	List<BookingEntity> findAll(Sort sort);

	List<BookingEntity> findAll();

	Page<BookingEntity> findAll(Pageable pageable);

	<S extends BookingEntity> Optional<S> findOne(Example<S> example);

	<S extends BookingEntity> S save(S entity);

}
