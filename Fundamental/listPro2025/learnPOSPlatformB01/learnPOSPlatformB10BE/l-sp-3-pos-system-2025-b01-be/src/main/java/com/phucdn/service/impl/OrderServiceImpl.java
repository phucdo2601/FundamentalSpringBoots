package com.phucdn.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phucdn.LSp3PosSystem2025B01BeApplication;
import com.phucdn.configuration.SecurityConfig;
import com.phucdn.controller.ProductController;
import com.phucdn.domain.OrderStatus;
import com.phucdn.domain.PaymentType;
import com.phucdn.mapper.OrderMapper;
import com.phucdn.model.Branch;
import com.phucdn.model.Order;
import com.phucdn.model.OrderItem;
import com.phucdn.model.Product;
import com.phucdn.model.User;
import com.phucdn.payload.dto.OrderDto;
import com.phucdn.repository.OrderRepository;
import com.phucdn.repository.ProductRepository;
import com.phucdn.service.OrderService;
import com.phucdn.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductController productController;

    private final LSp3PosSystem2025B01BeApplication LSp3PosSystem2025B01BeApplication;

	private final SecurityConfig securityConfig;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserService userService;

	OrderServiceImpl(SecurityConfig securityConfig, LSp3PosSystem2025B01BeApplication LSp3PosSystem2025B01BeApplication, ProductController productController) {
		this.securityConfig = securityConfig;
		this.LSp3PosSystem2025B01BeApplication = LSp3PosSystem2025B01BeApplication;
		this.productController = productController;
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) throws Exception {
		User cashier = userService.getCurrentUser();
		Branch branch = cashier.getBranch();

		if (branch == null) {
			throw new Exception("Cashier's branch not found.");
		}

		Order order = Order.builder().branch(branch).cashier(cashier).customer(orderDto.getCustomer())
				.paymentType(orderDto.getPaymentType()).build();

		List<OrderItem> orderItems = orderDto.getItems().stream().map(itemDto -> {
			Product product = productRepository.findById(itemDto.getProductId())
					.orElseThrow(() -> new EntityNotFoundException("Product not found"));

			return OrderItem.builder().product(product).quantity(itemDto.getQuantity())
					.price(product.getSellingPrice() * itemDto.getQuantity()).order(order).build();
		}).toList();

		Double total = orderItems.stream().mapToDouble(OrderItem::getPrice).sum();

		order.setTotalAmount(total);
		order.setItems(orderItems);

		Order savedOrder = orderRepository.save(order);

		return OrderMapper.toDto(savedOrder);
	}

	@Override
	public OrderDto getOrderById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).map(OrderMapper::toDto)
				.orElseThrow(() -> new Exception("Order not found with id " + id));
	}

	@Override
	public List<OrderDto> getOrdersByBranch(Long branchId, Long customerId, Long cashierId, PaymentType paymentType,
			OrderStatus orderStatus) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.findByBrandId(branchId).stream()
				.filter(order -> customerId == null
						|| (order.getCustomer() != null && order.getCustomer().getId().equals(customerId)))
				.filter(order -> cashierId == null
						|| order.getCashier() != null && order.getCashier().getId().equals(cashierId))
				.filter(order -> paymentType == null || order.getPaymentType() == paymentType).map(OrderMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> getOrderByCashier(Long cashierId) {
		return orderRepository.findByCashierId(cashierId).stream().map(OrderMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public void deleteOrder(Long id) throws Exception {
		Order order = orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found with id " +id));
		orderRepository.delete(order);
	}

	@Override
	public List<OrderDto> getTodayOrdersByBranchId(Long branchId) throws Exception {
		LocalDate today = LocalDate.now();
		LocalDateTime start = today.atStartOfDay();
		LocalDateTime end = today.plusDays(1).atStartOfDay();
		return orderRepository.findByBranchIdAndCreatedAtBetween(branchId, start, end).stream().map(OrderMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> getOrdersByCustomerId(Long customerId) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.findByCustomerId(customerId).stream().map(OrderMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> getTop5RecentOrdersByBranchId(Long branchId) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.findTop5ByBranchIdOrderByCreatedAtDesc(branchId).stream().map(OrderMapper::toDto).collect(Collectors.toList());
	}

}
