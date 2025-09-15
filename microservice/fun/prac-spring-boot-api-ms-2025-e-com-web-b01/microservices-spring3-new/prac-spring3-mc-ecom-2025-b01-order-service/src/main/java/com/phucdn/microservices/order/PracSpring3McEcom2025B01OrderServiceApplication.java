package com.phucdn.microservices.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.phucdn.microservices.order.client")
public class PracSpring3McEcom2025B01OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracSpring3McEcom2025B01OrderServiceApplication.class, args);
	}

}
