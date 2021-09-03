package com.phucdn.learnSpringJPA.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringJPA.entity.Todo;
import com.phucdn.learnSpringJPA.repository.TodoRepository;
import com.phucdn.learnSpringJPA.service.TodoService;
import com.phucdn.learnSpringJPA.validation.TodoValidator;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private TodoValidator todoValidator;
	
	/**
     * Lấy ra danh sách List<Todo>
     *
     * @param limit - Giới hạn số lượng lấy ra
     *
     * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả findAll()
     */
	@Override
	public List<Todo> findAll(Integer limit) {
		return Optional.ofNullable(limit)
					.map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
					.orElseGet(() -> todoRepository.findAll());
	}
	
	@Override
	public Todo add(Todo todo) {
		if (todoValidator.isValid(todo)) {
			return todoRepository.save(todo);
		}
		return null;
	}
	
	
}
