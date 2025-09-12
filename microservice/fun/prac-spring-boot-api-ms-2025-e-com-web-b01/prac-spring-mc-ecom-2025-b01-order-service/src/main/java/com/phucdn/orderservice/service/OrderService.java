package com.phucdn.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.orderservice.dto.OrderLineItemDto;
import com.phucdn.orderservice.dto.OrderRequest;
import com.phucdn.orderservice.model.Order;
import com.phucdn.orderservice.model.OrderLineItem;
import com.phucdn.orderservice.repository.OrderRepository;

@Service
@Transactional
public class OrderService implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItem> orderLineItem = orderRequest.getOrderLineItemDtoList()
			.stream()
			.map(orderLineItemDto -> mapToDto(orderLineItemDto)).toList();
		
		order.setOrderLineItemList(orderLineItem);
		
		orderRepository.save(order);
	}
	
	private OrderLineItem mapToDto(OrderLineItemDto orderLineItemDto) {
		OrderLineItem orderLineItem = new OrderLineItem();
		return orderLineItem.builder()
			.price(orderLineItemDto.getPrice())
			.quantity(orderLineItemDto.getQuantity())
			.skuCode(orderLineItemDto.getSkuCode())
			.build();
	}
}
