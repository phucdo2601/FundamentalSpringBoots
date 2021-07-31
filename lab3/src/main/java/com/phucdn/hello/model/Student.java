package com.phucdn.hello.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Student {
	@NotEmpty
	private String studentID;
	@NotEmpty(message = "{NotEmpty.student.name}")
	@Min(value = 4)
	private String name;
	@Email
	@NotEmpty
	private String email;
	@Min(value = 0)
	@Max(value = 10)
	private Double mark;
	
	private String faculty;
	
	private Boolean gender;
	private List<String> hobbies;
	private MultipartFile imageFile;
	private String imageUrl;
}
