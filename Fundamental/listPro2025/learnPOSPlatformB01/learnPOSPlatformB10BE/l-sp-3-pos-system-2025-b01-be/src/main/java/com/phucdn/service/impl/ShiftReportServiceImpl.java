package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.domain.PaymentType;
import com.phucdn.mapper.ShiftReportMapper;
import com.phucdn.model.Branch;
import com.phucdn.model.Order;
import com.phucdn.model.OrderItem;
import com.phucdn.model.PaymentSummary;
import com.phucdn.model.Product;
import com.phucdn.model.Refund;
import com.phucdn.model.ShiftReport;
import com.phucdn.model.User;
import com.phucdn.payload.dto.ShiftReportDto;
import com.phucdn.repository.BranchRepository;
import com.phucdn.repository.OrderRepository;
import com.phucdn.repository.RefundRepository;
import com.phucdn.repository.ShiftReportRepository;
import com.phucdn.repository.UserRepository;
import com.phucdn.service.ShiftReportService;
import com.phucdn.service.UserService;

@Service
public class ShiftReportServiceImpl implements ShiftReportService {

	@Autowired
	private ShiftReportRepository shiftReportRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private RefundRepository refundRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Override
	public ShiftReportDto startShift()
			throws Exception {
		User currentUser = userService.getCurrentUser();
		LocalDateTime shiftStart = LocalDateTime.now();

		LocalDateTime startOfDay = shiftStart.withHour(0).withMinute(0).withSecond(0);
		LocalDateTime endOfDay = shiftStart.withHour(23).withMinute(59).withSecond(59);

		Optional<ShiftReport> existing = shiftReportRepository.findByCashierAndShiftStartBetween(currentUser,
				startOfDay, endOfDay);

		if (existing.isPresent()) {
			throw new Exception("Shift already started today.");
		}

		Branch branch = currentUser.getBranch();

		ShiftReport shiftReport = ShiftReport.builder().cashier(currentUser).shiftStart(shiftStart).branch(branch)
				.build();

		ShiftReport savedReport = shiftReportRepository.save(shiftReport);

		return ShiftReportMapper.toDto(savedReport);
	}

	@Override
	public ShiftReportDto endShift(Long shiftReportId, LocalDateTime shiftEnd) throws Exception {
		User currentUser = userService.getCurrentUser();
		ShiftReport shiftReport = shiftReportRepository
				.findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(currentUser)
				.orElseThrow(() -> new Exception("Shift not found!"));
		shiftReport.setShiftEnd(shiftEnd);

		List<Refund> refunds = refundRepository.findByCashierIdAndCreatedAtBetween(currentUser.getId(),
				shiftReport.getShiftStart(), shiftReport.getShiftEnd());

		Double totalRefunds = refunds.stream()
				.mapToDouble(refund -> refund.getAmount() != null ? refund.getAmount() : 0.0).sum();

		List<Order> orders = orderRepository.findByCashierAndCreatedAtBetween(currentUser, shiftReport.getShiftStart(),
				shiftReport.getShiftEnd());

		Double totalSales = orders.stream().mapToDouble(Order::getTotalAmount).sum();

		int totalOrders = orders.size();

		Double netSales = totalSales - totalRefunds;

		shiftReport.setTotalRefunds(totalRefunds);
		shiftReport.setTotalSales(totalSales);
		shiftReport.setTotalOrders(totalOrders);
		shiftReport.setNetSale(netSales);
		shiftReport.setRecentOrders(getRecentOrders(orders));
		shiftReport.setTopSellingProducts(getTopSellingProducts(orders));
		shiftReport.setPaymentSummaries(getPaymentSummaries(orders, totalSales));
		shiftReport.setRefunds(refunds);
		
		ShiftReport savedReport = shiftReportRepository.save(shiftReport);

		return ShiftReportMapper.toDto(savedReport);
	}

	@Override
	public ShiftReportDto getShiftReportById(Long id) throws Exception {
		ShiftReport shiftReport = shiftReportRepository.findById(id).orElseThrow(() -> new Exception("Shift report not found with given id "+id));
		return ShiftReportMapper.toDto(shiftReport);
	}

	@Override
	public List<ShiftReportDto> getAllShiftReports() {
		List<ShiftReport> reports = shiftReportRepository.findAll();
		
		return reports.stream().map(ShiftReportMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ShiftReportDto> getShiftReportsByBranchId(Long branchId) {
		List<ShiftReport> reports = shiftReportRepository.findByBranchId(branchId);
		
		return reports.stream().map(ShiftReportMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ShiftReportDto> getShiftReportsByCashierId(Long cashierId) {
		List<ShiftReport> reports = shiftReportRepository.findByCashierId(cashierId);
		
		return reports.stream().map(ShiftReportMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public ShiftReportDto getCurrentShiftProgress(Long cashierId) throws Exception {
		User currentUser = userService.getCurrentUser();
		
		ShiftReport shiftReport = shiftReportRepository
				.findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(currentUser)
				.orElseThrow(() -> new Exception("No Active shift found for cashier"));
		
		LocalDateTime now = LocalDateTime.now();
		List<Order> orders = orderRepository.findByCashierAndCreatedAtBetween(currentUser, shiftReport.getShiftStart(), now);
		List<Refund> refunds = refundRepository.findByCashierIdAndCreatedAtBetween(currentUser.getId(), shiftReport.getShiftStart(), now);
		
		double totalRefunds = refunds.stream().mapToDouble(refund -> refund.getAmount() != null ? refund.getAmount() : 0.0).sum();
		double totalSales = orders.stream().mapToDouble(Order::getTotalAmount).sum();
		int totalOrders = orders.size();
		
		Double netSales = totalSales - totalRefunds;

		shiftReport.setTotalRefunds(totalRefunds);
		shiftReport.setTotalSales(totalSales);
		shiftReport.setTotalOrders(totalOrders);
		shiftReport.setNetSale(netSales);
		shiftReport.setRecentOrders(getRecentOrders(orders));
		shiftReport.setTopSellingProducts(getTopSellingProducts(orders));
		shiftReport.setPaymentSummaries(getPaymentSummaries(orders, totalSales));
		shiftReport.setRefunds(refunds);
		
		ShiftReport savedReport = shiftReportRepository.save(shiftReport);
		
		return ShiftReportMapper.toDto(savedReport);

	}

	@Override
	public ShiftReportDto getShiftByCashierAndDate(Long cashierId, LocalDateTime date) throws Exception {
		User cashier = userRepository.findById(cashierId).orElseThrow(() -> new Exception("cashier is not found with given id"+cashierId));
		LocalDateTime start = date.withHour(0).withMinute(0).withSecond(0);
		LocalDateTime end = date.withHour(23).withMinute(59).withSecond(59);
		
		ShiftReport report = shiftReportRepository.findByCashierAndShiftStartBetween(cashier, start, end).orElseThrow(() -> new Exception("Shift report not found for date"));
		
		return ShiftReportMapper.toDto(report);
	}
	
	// ------------------ Helper Methods
	private List<PaymentSummary> getPaymentSummaries(List<Order> orders, Double totalSales) {
		// CASH - order 1(amount = 1000), order 2(amount = 1000) => 2000
		// card - order 3 => 3000
		// upi = order 4(amount = 1000), order 5(amount = 500) => 1500
		
		// cash = 30%
		// card = 50%
		// upi = 20%
		
		Map<PaymentType, List<Order>> grouped = orders.stream().collect(Collectors
				.groupingBy(order -> order.getPaymentType() != null ? order.getPaymentType() : PaymentType.CASH));
		
		List<PaymentSummary> summaries = new ArrayList<>();
		for(Map.Entry<PaymentType, List<Order>> entry : grouped.entrySet()) {
			double amount = entry.getValue().stream().mapToDouble(Order::getTotalAmount).sum();
			
			int transactions = entry.getValue().size();
			double percent = (amount / totalSales) * 100;
			
			PaymentSummary ps = new PaymentSummary();
			ps.setPaymentType(entry.getKey());
			ps.setTotalAmount(amount);
			ps.setTransactionCount(transactions);
			ps.setPercentage(percent);
			summaries.add(ps);
		}
		
		return summaries;
	}

	private List<Product> getTopSellingProducts(List<Order> orders) {
		Map<Product, Integer> productSalesMap = new HashMap<>();

		// p1 - 5
		// p2 - 1
		// p3 - 4
		// p4 - 8

		for (Order order : orders) {
			for (OrderItem item : order.getItems()) {
				Product product = item.getProduct();
				productSalesMap.put(product, productSalesMap.getOrDefault(product, 0) + item.getQuantity());
			}
		}

		return productSalesMap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).limit(5)
				.map(Map.Entry::getKey).collect(Collectors.toList());
	}

	private List<Order> getRecentOrders(List<Order> orders) {
		return orders.stream().sorted(Comparator.comparing(Order::getCreatedAt).reversed()).limit(5)
				.collect(Collectors.toList());
	}

}
