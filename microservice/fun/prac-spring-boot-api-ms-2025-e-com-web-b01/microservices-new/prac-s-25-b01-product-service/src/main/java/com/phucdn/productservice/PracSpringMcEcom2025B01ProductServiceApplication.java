package com.phucdn.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PracSpringMcEcom2025B01ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracSpringMcEcom2025B01ProductServiceApplication.class, args);
	}

}
