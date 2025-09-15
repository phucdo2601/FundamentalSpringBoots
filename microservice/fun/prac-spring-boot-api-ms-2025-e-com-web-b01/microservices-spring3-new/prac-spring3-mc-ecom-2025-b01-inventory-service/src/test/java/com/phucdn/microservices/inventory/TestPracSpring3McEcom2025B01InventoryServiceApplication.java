package com.phucdn.microservices.inventory;

import org.springframework.boot.SpringApplication;

public class TestPracSpring3McEcom2025B01InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PracSpring3McEcom2025B01InventoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
