package com.phucdn.learnSpringSecurity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phucdn.learnSpringSecurity.controller.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest
class LearnSpringCrudMongoDbB2ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private EmployeeController employeeController;
	
	

	@Test
	public void contextLoads() {
		assertThat(employeeController).isNotNull();
	}
}
