package com.phucdn.payload.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.phucdn.model.PaymentSummary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftReportDto {

	private Long id;

	private LocalDateTime shiftStart;
	private LocalDateTime shiftEnd;
	
	private Double totalSales;
	private Double totalRefunds;
	
	private Double netSale;
	private int totalOrders;
	
	private UserDto cashier;
	private Long cashierId;
	private Long branchId;
	
	private BranchDto branch;

	private List<PaymentSummary> paymentSummaries; 
	
	private List<ProductDto> topSellingProducts;
	
	private List<OrderDto> recentOrders;

	private List<RefundDto> refunds;
}
