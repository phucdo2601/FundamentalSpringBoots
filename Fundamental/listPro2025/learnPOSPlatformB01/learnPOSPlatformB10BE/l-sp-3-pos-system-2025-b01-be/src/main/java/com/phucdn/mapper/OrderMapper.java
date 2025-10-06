package com.phucdn.mapper;

import java.util.stream.Collectors;

import com.phucdn.model.Order;
import com.phucdn.payload.dto.OrderDto;

public class OrderMapper {
	public static OrderDto toDto(Order order) {
		return OrderDto.builder()
				.id(order.getId())
				.totalAmount(order.getTotalAmount())
				.branchId(order.getBranch().getId())
				.cashier(UserMapper.toDto(order.getCashier()))
				.customer(order.getCustomer())
				.paymentType(order.getPaymentType())
				.createdAt(order.getCreatedAt())
				.items(
						order.getItems().stream().map(OrderItemMapper::toDto)
						.collect(Collectors.toList())
				)
				.build();
	}
}
