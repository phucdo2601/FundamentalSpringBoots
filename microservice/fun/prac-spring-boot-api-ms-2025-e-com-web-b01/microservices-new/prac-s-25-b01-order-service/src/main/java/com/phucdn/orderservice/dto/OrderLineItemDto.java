package com.phucdn.orderservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
