package com.phucdn.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

// @FeignClient(name = "inventory", url = "${inventory.url}") 
public interface InventoryClient {
	// @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
	// boolean isInStock(@RequestParam(name = "skuCode") String skuCode, @RequestParam(name = "quantity") Integer quantity);

	@GetExchange("/api/inventory")
	boolean isInStock(@RequestParam(name = "skuCode") String skuCode, @RequestParam(name = "quantity") Integer quantity);
}
