package com.phucdn.microservices.order.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.microservices.order.client.InventoryClient;
import com.phucdn.microservices.order.dto.OrderRequest;
import com.phucdn.microservices.order.model.Order;
import com.phucdn.microservices.order.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private InventoryClient inventoryClient;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		boolean inStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());
		
		if (inStock) {
			var order = mapToOrder(orderRequest);
			orderRepository.save(order);
		} else {
			throw new RuntimeException("Product with Skucode " + orderRequest.getSkuCode() + "is not in stock");
		}
	}
	
	private static Order mapToOrder(OrderRequest orderRequest) {
		Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setSkuCode(orderRequest.getSkuCode());
        return order;
	}
}
