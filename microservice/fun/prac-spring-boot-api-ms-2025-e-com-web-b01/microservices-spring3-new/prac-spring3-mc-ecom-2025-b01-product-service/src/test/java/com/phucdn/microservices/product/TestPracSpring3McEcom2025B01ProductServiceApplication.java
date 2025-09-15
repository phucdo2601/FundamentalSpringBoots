package com.phucdn.microservices.product;

import org.springframework.boot.SpringApplication;

public class TestPracSpring3McEcom2025B01ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PracSpring3McEcom2025B01ProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
