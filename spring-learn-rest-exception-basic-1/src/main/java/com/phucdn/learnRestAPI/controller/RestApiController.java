package com.phucdn.learnRestAPI.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnRestAPI.model.Todo;

/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 * <p>
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 * @author ASUS
 *
 */
@RestController
@RequestMapping("/api/v1")
public class RestApiController {
	
	private List<Todo> todoList;
	
	/**
	 * phan path URL ban muon lay thong tin se de trong ngoac kep {}
	 */
	@PostConstruct
	public void init() {
		todoList = IntStream.range(0, 10)
				.mapToObj(i -> new Todo("title-"+i, "detail-"+i))
				.collect(Collectors.toList());
	}
	
	/*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
	@GetMapping("/todo/{todoId}")
	public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
		// @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
		return todoList.get(todoId);
	}
}
