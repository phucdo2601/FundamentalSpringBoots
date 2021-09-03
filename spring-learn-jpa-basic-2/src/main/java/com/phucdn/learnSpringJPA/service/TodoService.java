package com.phucdn.learnSpringJPA.service;

import java.util.List;

import com.phucdn.learnSpringJPA.entity.Todo;

public interface TodoService {

	Todo add(Todo todo);

	/**
	 * Lấy ra danh sách List<Todo>
	 *
	 * @param limit - Giới hạn số lượng lấy ra
	 *
	 * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả findAll()
	 */
	List<Todo> findAll(Integer limit);

}
