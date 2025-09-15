package com.phucdn.microservices.order.dto;

import java.math.BigDecimal;

import com.phucdn.microservices.order.model.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
