package com.phucdn.payload.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.phucdn.domain.PaymentType;
import com.phucdn.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
	private Long id;
	
	private Double totalAmount;
	
	private LocalDateTime createdAt;
	
	private Long branchId;
	
	private Long customerId;

	private BranchDto branch;

	private UserDto cashier;

	private Customer customer;
	
	private PaymentType paymentType;
	
	private List<OrderItemDto> items;
}
