package com.phucdn.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.payload.dto.RefundDto;
import com.phucdn.service.RefundService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/refunds")
@RequiredArgsConstructor
public class RefundController {

	private final RefundService refundService;
	
	@PostMapping
	public ResponseEntity<RefundDto> createRefund(@RequestBody RefundDto refundDto) throws Exception {
		return ResponseEntity.ok(refundService.createRefund(refundDto));
	}
	
	@GetMapping
	public ResponseEntity<List<RefundDto>> getAllRefunds() throws Exception {
		return ResponseEntity.ok(refundService.getAllRefunds());
	}
	
	@GetMapping("/cashier/{cashierId}")
	public ResponseEntity<List<RefundDto>> getRefundByCashier(@PathVariable Long cashierId) throws Exception {
		return ResponseEntity.ok(refundService.getRefundByCashier(cashierId));
	}
	
	@GetMapping("/branch/{branchId}")
	public ResponseEntity<List<RefundDto>> getRefundByBrannch(@PathVariable Long branchId) throws Exception {
		return ResponseEntity.ok(refundService.getRefundByBranch(branchId));
	}
	
	@GetMapping("/shift/{shiftReportId}")
	public ResponseEntity<List<RefundDto>> getRefundByShift(@PathVariable Long shiftReportId) throws Exception {
		List<RefundDto> refund = refundService.getRefundByShiftReport(shiftReportId);
		return ResponseEntity.ok(refund);
	}
	
	@GetMapping("/cashier/{cashierId}/range")
	public ResponseEntity<List<RefundDto>> getRefundByCashierAndRangeDate(
			@PathVariable Long cashierId,
			@RequestParam @DateTimeFormat (iso = ISO.DATE_TIME) LocalDateTime start,
			@RequestParam @DateTimeFormat (iso = ISO.DATE_TIME) LocalDateTime end
			) throws Exception {
		return ResponseEntity.ok(refundService.getRefundByCashierAndDateRange(cashierId, start, end));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RefundDto> getRefundById(@PathVariable Long id) throws Exception {
		RefundDto refund = refundService.getRefundById(id);
		return ResponseEntity.ok(refund);
		
	}
}
