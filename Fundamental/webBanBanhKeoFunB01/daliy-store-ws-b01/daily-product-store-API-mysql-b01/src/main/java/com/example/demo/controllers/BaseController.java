package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.ErrorMessage;
import com.example.demo.models.BaseEntity;
import com.example.demo.services.BaseService;

public class BaseController<T extends BaseEntity, C, Service extends BaseService<T, C>> {

	private final BaseService<T, C> service;

	public BaseController(BaseService<T, C> service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		List<T> listData = new ArrayList<>();
		listData = (List<T>) service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(listData);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") UUID id) {
		Optional<T> res = service.get(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody C model) {

		try {
			T createModel = service.convertDtoToEntity(model);
			T savedEntity = service.create(createModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
		} catch (NumberFormatException ex) {
			ErrorMessage errMsg = new ErrorMessage();
			errMsg.setErrorMessage("The field with number type does not valid!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMsg);
		} catch (IllegalArgumentException e) {
			ErrorMessage errMsg = new ErrorMessage();
			errMsg.setErrorMessage("The field with UUID type does not valid!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMsg);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody C model) {
		T updateModel = service.convertDtoToEntity(model);
		updateModel.setId(id);
		Optional<T> updatedObj = service.update(updateModel);
		return ResponseEntity.status(HttpStatus.OK).body(updatedObj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
