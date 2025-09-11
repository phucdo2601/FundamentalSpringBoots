package com.phucdn.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LEmployeeServiceApplication.class, args);
	}

}
