package com.phucdn.mapper;

import com.phucdn.model.OrderItem;
import com.phucdn.payload.dto.OrderItemDto;

public class OrderItemMapper {
	public static OrderItemDto toDto(OrderItem orderItem) {
		if (orderItem == null) {
			return null;
		}
		return OrderItemDto.builder()
				.id(orderItem.getId())
				.productId(orderItem.getProduct().getId())
				.quantity(orderItem.getQuantity())
				.price(orderItem.getPrice())
				.product(ProductMapper.toDto(orderItem.getProduct()))
				.build();
	}
}
