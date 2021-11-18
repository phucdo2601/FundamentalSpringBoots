package com.phucdn.shoppingPage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.phucdn.shoppingPage.validator.ItemValidator;

@Configuration
public class ItemConfig {

	@Bean
	public ItemValidator validator() {
		return new ItemValidator();
	}
}
