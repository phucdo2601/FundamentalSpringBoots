package com.phucdn.learnSpringJPA.validation;

import java.util.Optional;

import org.thymeleaf.util.StringUtils;

import com.phucdn.learnSpringJPA.entity.Todo;

public class TodoValidator {
	public boolean isValid(Todo todo) {
		return Optional.ofNullable(todo)
				.filter(t -> !StringUtils.isEmpty(t.getTitle())) // Kiem Tra title khac rong
				.filter(t -> !StringUtils.isEmpty(t.getDetail())) // kiem Tra detail khac rong
				.isPresent(); // Tra ve true neu hop le, nguoc lai false
	}
}
