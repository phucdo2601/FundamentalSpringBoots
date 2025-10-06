package com.phucdn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.domain.OrderStatus;
import com.phucdn.domain.PaymentType;
import com.phucdn.payload.dto.OrderDto;
import com.phucdn.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) throws Exception {
		return ResponseEntity.ok(orderService.createOrder(orderDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	@GetMapping("/branch/{branchId}")
	public ResponseEntity<List<OrderDto>> getOrderByBranch(
			@PathVariable Long branchId,
			@RequestParam(required = false) Long customerId,
			@RequestParam(required = false) Long cashierId,
			@RequestParam(required = false) PaymentType paymentType,
			@RequestParam(required = false) OrderStatus orderStatus
			) throws Exception {
		return ResponseEntity.ok(orderService.getOrdersByBranch(branchId, customerId, cashierId, paymentType, orderStatus));
	}
	
	@GetMapping("/cashier/{id}")
	public ResponseEntity<List<OrderDto>> getOrderByCashier(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.getOrderByCashier(id));
	}
	
	@GetMapping("/today/branch/{id}")
	public ResponseEntity<List<OrderDto>> getTodayOrder(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(orderService.getTodayOrdersByBranchId(id));
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<OrderDto>> getCustomersOrder(@PathVariable Long id) throws Exception {
		 return ResponseEntity.ok(orderService.getOrdersByCustomerId(id));
	}
	
	@GetMapping("/recent/{branchId}")
	public ResponseEntity<List<OrderDto>> getRecentOrder(@PathVariable Long branchId) throws Exception {
		return ResponseEntity.ok(orderService.getTop5RecentOrdersByBranchId(branchId));
	}
}
