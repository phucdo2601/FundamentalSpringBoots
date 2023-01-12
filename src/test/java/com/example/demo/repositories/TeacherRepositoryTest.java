package com.example.demo.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.TeacherEntity;

@SpringBootTest
public class TeacherRepositoryTest {
	@Autowired
	private TeacherRepository teacherRepository;

//	@Test
//	public void saveTeacher() {
//
//		CourseEntity courseDBA = CourseEntity.builder().title("DBA").credit(5).build();
//
//		CourseEntity courseJava = CourseEntity.builder().title("Java").credit(6).build();
//
//		TeacherEntity teacher = TeacherEntity.builder().firstName("Qutub").lastName("Khan")
//				.courses(List.of(courseDBA, courseJava)).build();
//
//		teacherRepository.save(teacher);
//	}
}
