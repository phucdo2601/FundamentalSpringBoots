package com.phucdn.payload.dto;

import java.time.LocalDateTime;

import com.phucdn.domain.PaymentType;
import com.phucdn.model.ShiftReport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefundDto {
	private Long id;
	
	private OrderDto order;
	
	private Long orderId;

	private String reason;
	
	private Double amount;
	
	private ShiftReport shiftReport;
	
	private Long shiftReportId;
	
	private UserDto cashier;
	
	private String cashierName;

	private BranchDto branch;
	
	private Long branchId;
	
	private PaymentType paymentType;
	
	private LocalDateTime createdAt;
}
