package com.example.demo.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.CourseMaterialEntity;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		CourseEntity course =
                CourseEntity.builder()
                .title(".net")
                .credit(6)
                .build();
		
		CourseMaterialEntity courseMaterial =
				CourseMaterialEntity.builder()
                .url("www.phucdnTest1.com")
                .course(course)
                .build();
		
		courseMaterialRepository.save(courseMaterial);
	}
	
//	@Test
//	public void printAllCourseMaterials() {
//		List<CourseMaterialEntity> courseMaterial = courseMaterialRepository.findAll();
//		System.out.println("Course Material: "+courseMaterial);
//	}
}
