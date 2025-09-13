package com.phucdn.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.phucdn.inventoryservice.model.Inventory;
import com.phucdn.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class PracSpringMcEcom2025B01InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracSpringMcEcom2025B01InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
//		return args -> {
//			Inventory inventory1 = new Inventory();
//			inventory1.setSkuCode("Iphone_13");
//			inventory1.setQuantity(0);
//			
//			Inventory inventory2 = new Inventory();
//			inventory2.setSkuCode("Iphone_14");
//			inventory2.setQuantity(100);
//			
//			inventoryRepository.deleteAll();
//			inventoryRepository.save(inventory1);
//			inventoryRepository.save(inventory2);
//		};
//		
//	}
}
