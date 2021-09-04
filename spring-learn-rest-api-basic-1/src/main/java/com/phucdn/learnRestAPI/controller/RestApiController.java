package com.phucdn.learnRestAPI.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnRestAPI.model.Todo;

/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 * 
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 */
@RestController
@RequestMapping("/api/v1")
public class RestApiController {
	
	private List<Todo> todoList = new CopyOnWriteArrayList<>();
	
	//@PostConstruct được đánh dấu trên một method duy nhất bên trong Bean
	@PostConstruct
	public void init() {
		//Them null vao list de bo qua vi tri so 0;
		todoList.add(null);
	}
	
	@GetMapping("/todo")
	public List<Todo> getTodoList() {
		return todoList;
	}
	/**
	 * phan path URL ban muon lay thong tin se de trong ngoac kep {}
	 * @param todoId
	 * @return
	 */
	@GetMapping("/todo/{todoId}")
	public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
		//@PathVariable lay ra thong tin  tren url
		//dua vao ten cua thuoc tinh da dinh nghia trong ngoac kep /todo/{todoId}
		return todoList.get(todoId);
	}
	
	/**
	 * @RequestBody noi voi spring Boot hay chuyen JSON trong request body thanh doi tuong 
	 */
	@PutMapping("/todo/{todoId}")
	public Todo editTodo(@PathVariable(name = "todoId") Integer todoId,
			@RequestBody Todo todo) {
		todoList.set(todoId, todo);
		//Tra ve doi tuong sau khi da edit
		return todo;
	}
	
	@DeleteMapping("/todo/{todoId}")
	public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId) {
		todoList.remove(todoId.intValue());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/todo")
	public ResponseEntity addTodo(@RequestBody Todo todo) {
		todoList.add(todo);
		//Tra ve response voi status code = 200 (ok)
		//Body se chua thong tin ve doi tuong todo
		
		return ResponseEntity.ok().build();
	}
	
	
	
}
