package com.example.demo.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.GuardianEntity;
import com.example.demo.entities.StudentEntity;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
//	public void saveStudent() {
//		StudentEntity student = StudentEntity.builder()
//				.emailId("ngocphucdo2601@gmail.com")
//				.firstName("Phuc")
//				.lastName("Do")
////				.guardianName("PhucDo")
////				.guardianEmail("phucdo2601@gmail.com")
////				.guardianMobile("987654321")
//				.build();
//		
//		studentRepository.save(student);
//	}
	
	@Test
	public void saveStudentGuardian() {
		GuardianEntity guardian = GuardianEntity.builder()
				.name("Adam Tran")
				.email("anhTran01@gmail.com")
				.mobile("453534535")
				.build();
		
		StudentEntity student = StudentEntity.builder()
				.emailId("adamTran01@gmail.com")
				.firstName("Anh")
				.lastName("Tran")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
		
	}
//	
//	@Test
//	public void printAllStudents() {
//		List<StudentEntity> studentList = studentRepository.findAll();
//		System.out.println("List of student: "+studentList);
//	}
	
//	@Test
//	public void printStudentByFirstName() {
//		List<StudentEntity> studentList = studentRepository.findByFirstName("Phuc");
//		System.out.println("List of student finb by firstName: "+studentList);
//	}
	
//	@Test
//	public void printStudentByFirstNameContaining() {
//		List<StudentEntity> studentList = studentRepository.findByFirstNameContaining("Phuc");
//		System.out.println("List of student finb by firstName containing: "+studentList);
//	}
	
//	@Test
//	public void printStudentByGuardianName() {
//		List<StudentEntity> studentList = studentRepository.findByGuardianName("PhucDo");
//		System.out.println("List of student finb by GuardianName: "+studentList);
//	}
	
	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("Phuc Do Ngoc", "test01@gmail.com");
		System.out.println("Update updateStudentNameByEmailId is successfully!");
	}
}
