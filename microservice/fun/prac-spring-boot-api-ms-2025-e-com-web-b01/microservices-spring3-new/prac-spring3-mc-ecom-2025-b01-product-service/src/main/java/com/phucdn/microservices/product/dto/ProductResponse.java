package com.phucdn.microservices.product.dto;

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
public class ProductResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
