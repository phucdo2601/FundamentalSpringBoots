package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.models.BaseEntity;
import com.example.demo.repositories.BaseRepository;

public interface BaseService<T extends BaseEntity, C> {
	BaseRepository<T> getRepository();

	/**
	 * Basic default method in interface
	 */
	default T create(T t) {
		return getRepository().save(t);
	}

	default Optional<T> get(UUID id) {
		return getRepository().findById(id);
	}

	default List<T> getAll() {
		return getRepository().findAll();
	}

	default Optional<T> update(T t) {
		if (getRepository().existsById(t.getId())) {
			return Optional.of(getRepository().save(t));
		}

		return Optional.empty();
	}

	default void delete(UUID id) {
		getRepository().deleteById(id);
	}

	public C convertEntityToDto(T t);

	public T convertDtoToEntity(C c);
}
