package com.phucdn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.phucdn.model.Order;
import com.phucdn.model.Product;
import com.phucdn.model.Refund;
import com.phucdn.model.ShiftReport;
import com.phucdn.payload.dto.OrderDto;
import com.phucdn.payload.dto.ProductDto;
import com.phucdn.payload.dto.RefundDto;
import com.phucdn.payload.dto.ShiftReportDto;

public class ShiftReportMapper {
	public static ShiftReportDto toDto(ShiftReport entity) {
		return ShiftReportDto.builder()
				.id(entity.getId())
				.shiftEnd(entity.getShiftEnd())
				.shiftStart(entity.getShiftStart())
				.totalSales(entity.getTotalSales())
				.totalRefunds(entity.getTotalRefunds())
				.netSale(entity.getNetSale())
				.totalOrders(entity.getTotalOrders())
				.cashier(UserMapper.toDto(entity.getCashier()))
				.cashierId(entity.getCashier().getId())
				.branchId(entity.getBranch().getId())
				.recentOrders(mapOrders(entity.getRecentOrders()))
				.topSellingProducts(mapProducts(entity.getTopSellingProducts()))
				.refunds(mapRefunds(entity.getRefunds()))
				.paymentSummaries(entity.getPaymentSummaries())
				.build();
	}

	private static List<RefundDto> mapRefunds(List<Refund> refunds) {
		if (refunds == null || refunds.isEmpty()) {
			return null;
		}
		
		return refunds.stream().map(RefundMapper::toDto).collect(Collectors.toList());
	}

	private static List<ProductDto> mapProducts(List<Product> topSellingProducts) {
		if (topSellingProducts == null || topSellingProducts.isEmpty()) {
			return null;
		}
		
		return topSellingProducts.stream().map(ProductMapper::toDto).collect(Collectors.toList());
	}

	private static List<OrderDto> mapOrders(List<Order> recentOrders) {
		if (recentOrders == null || recentOrders.isEmpty()) {
			return null;
		}
		
		return recentOrders.stream().map(OrderMapper::toDto).collect(Collectors.toList());
	}
}
