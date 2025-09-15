package com.phucdn.microservices.order;

import org.springframework.boot.SpringApplication;

public class TestPracSpring3McEcom2025B01OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PracSpring3McEcom2025B01OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
