package com.phucdn.learnSpringSecurity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.service.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	
	
	@Test
	public void testReadAllUser() {
		List<UserEntity> list = userService.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
}
