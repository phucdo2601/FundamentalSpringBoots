package com.phucdn.orderservice.service;

import com.phucdn.orderservice.dto.OrderRequest;

public interface IOrderService {
	void placeOrder(OrderRequest orderRequest);
}
