package com.example.demo.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
//	@Test
//	public void printAllCourses() {
//		List<CourseEntity> course = courseRepository.findAll();
//		System.out.println("List Course : "+course);
//	}
	
//	@Test
//	public void saveCourseWithTeacher() {
//		TeacherEntity teacher = TeacherEntity.builder()	
//				.firstName("Phuc")
//				.lastName("Do")
//				.build();
//		CourseEntity course = CourseEntity.builder()
//				.title("Python")
//				.credit(7)
//				.teacher(teacher)
//				.build();
//		
//		courseRepository.save(course);
//		System.out.println("Save course is successfully!");
//	}
	
//	@Test
//	public void findAllPagination() {
//		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
//		 Pageable secondPageWithTwoRecords = 
//	                PageRequest.of(1,2);
//		 List<CourseEntity> courses =
//	                courseRepository.findAll(secondPageWithTwoRecords)
//	                        .getContent();
//
//	        long totalElements =
//	                courseRepository.findAll(secondPageWithTwoRecords)
//	                .getTotalElements();
//
//	        long totalPages =
//	                courseRepository.findAll(secondPageWithTwoRecords)
//	                .getTotalPages();
//
//	        System.out.println("totalPages = " + totalPages);
//	        
//	        System.out.println("totalElements = " + totalElements);
//
//	        System.out.println("courses = " + courses);
//	}
	
//	@Test
//    public void findAllSorting() {
//        Pageable sortByTitle =
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("title")
//                        );
//        Pageable sortByCreditDesc =
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("credit").descending()
//                );
//
//        Pageable sortByTitleAndCreditDesc =
//                PageRequest.of(
//                        0,
//                        2,
//                        Sort.by("title")
//                        .descending()
//                        .and(Sort.by("credit"))
//                );
//        
//        List<CourseEntity> courses
//                = courseRepository.findAll(sortByTitle).getContent();
//
//        System.out.println("courses = " + courses);
//    }
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPage = PageRequest.of(0, 10);
		List<CourseEntity> courses = courseRepository.findByTitleContaining("D", firstPage).getContent();
		
		System.out.println("courses= "+courses);
	}
	
	@Test
    public void saveCourseWithStudentAndTeacher() {

        TeacherEntity teacher = TeacherEntity.builder()
                .firstName("Donald")
                .lastName("Trump")
                .build();

        StudentEntity student = StudentEntity.builder()
                .firstName("Trung")
                .lastName("Do Nam")
                .emailId("trungdt@gmail.com")
                .build();

        CourseEntity course = CourseEntity
                .builder()
                .title("Go Lang")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }
}
