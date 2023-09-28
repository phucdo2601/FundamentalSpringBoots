package com.phucdn.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpoyeeAppConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
}
