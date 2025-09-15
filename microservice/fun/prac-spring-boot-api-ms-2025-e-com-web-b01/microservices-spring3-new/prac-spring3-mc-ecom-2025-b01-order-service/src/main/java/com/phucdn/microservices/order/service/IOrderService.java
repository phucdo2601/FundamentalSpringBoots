package com.phucdn.microservices.order.service;

import com.phucdn.microservices.order.dto.OrderRequest;

public interface IOrderService {
	void placeOrder(OrderRequest orderRequest);
}
