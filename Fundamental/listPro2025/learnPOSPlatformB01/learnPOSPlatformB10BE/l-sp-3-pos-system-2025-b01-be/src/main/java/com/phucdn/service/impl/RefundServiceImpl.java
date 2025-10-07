package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.mapper.RefundMapper;
import com.phucdn.model.Branch;
import com.phucdn.model.Order;
import com.phucdn.model.Refund;
import com.phucdn.model.User;
import com.phucdn.payload.dto.RefundDto;
import com.phucdn.repository.OrderRepository;
import com.phucdn.repository.RefundRepository;
import com.phucdn.service.RefundService;
import com.phucdn.service.UserService;

@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	private RefundRepository refundRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserService userService;

	@Override
	public RefundDto createRefund(RefundDto refundDto) throws Exception {
		User cashier = userService.getCurrentUser();
		;
		Order order = orderRepository.findById(refundDto.getOrderId())
				.orElseThrow(() -> new Exception("Order not found!"));

		Branch branch = order.getBranch();

		Refund createdRefund = Refund.builder().order(order).cashier(cashier).branch(branch)
				.reason(refundDto.getReason()).amount(refundDto.getAmount()).createdAt(refundDto.getCreatedAt())
				.build();

		Refund savedRefund = refundRepository.save(createdRefund);

		return RefundMapper.toDto(savedRefund);
	}

	@Override
	public List<RefundDto> getAllRefunds() throws Exception {
		return refundRepository.findAll().stream().map(RefundMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<RefundDto> getRefundByCashier(Long cashierId) throws Exception {
		return refundRepository.findByCashierId(cashierId).stream().map(RefundMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<RefundDto> getRefundByShiftReport(Long shiftReportId) throws Exception {
		return refundRepository.findByShiftReportId(shiftReportId).stream().map(RefundMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<RefundDto> getRefundByCashierAndDateRange(Long cashierId, LocalDateTime startDate,
			LocalDateTime endDate) throws Exception {
		return refundRepository.findByCashierIdAndCreatedAtBetween(cashierId, startDate, endDate).stream()
				.map(RefundMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<RefundDto> getRefundByBranch(Long branchId) throws Exception {
		return refundRepository.findByBranchId(branchId).stream()
				.map(RefundMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public RefundDto getRefundById(Long refundId) throws Exception {
		return refundRepository.findById(refundId).map(RefundMapper::toDto).orElseThrow(() ->new Exception("Refund not found!"));
	}

	@Override
	public void deleteRefund(Long refundId) throws Exception {
		this.getRefundById(refundId);
		refundRepository.deleteById(refundId);
	}

}
