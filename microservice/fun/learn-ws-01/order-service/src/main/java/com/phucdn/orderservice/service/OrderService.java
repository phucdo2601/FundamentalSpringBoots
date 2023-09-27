package com.phucdn.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.orderservice.dto.OrderLineItemsDto;
import com.phucdn.orderservice.dto.OrderRequest;
import com.phucdn.orderservice.model.Order;
import com.phucdn.orderservice.model.OrderLineItems;
import com.phucdn.orderservice.repository.OrderRepostiory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	
	private final OrderRepostiory orderRepostiory;
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems =  orderRequest.getOrderLineItemsDtoList()
			.stream()
			.map(this::mapToDto).toList();
		
		order.setOrderLineItemsList(orderLineItems);
		
		orderRepostiory.save(order);
	}
	
	public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		
		return orderLineItems;
	}
}
