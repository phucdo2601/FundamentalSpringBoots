package com.phucdn.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.payload.dto.ShiftReportDto;
import com.phucdn.service.ShiftReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/shift-reports")
@RequiredArgsConstructor
public class ShiftReportController {

	private final ShiftReportService shiftReportService;

	@PostMapping("/start")
	public ResponseEntity<ShiftReportDto> startShift() throws Exception {
		return ResponseEntity.ok(shiftReportService.startShift());
	}

	@PatchMapping("/end")
	public ResponseEntity<ShiftReportDto> endShift() throws Exception {
		return ResponseEntity.ok(shiftReportService.endShift(null, null));
	}

	@GetMapping("/current")
	public ResponseEntity<ShiftReportDto> getCurrentShiftProgress() throws Exception {
		return ResponseEntity.ok(shiftReportService.getCurrentShiftProgress(null));
	}

	@GetMapping("/cashier/{cashierId}/by-date")
	public ResponseEntity<ShiftReportDto> getShiftReportByDate(@PathVariable Long cashierId,
			@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDateTime date) throws Exception {
		return ResponseEntity.ok(shiftReportService.getShiftByCashierAndDate(cashierId, date));
	}
	
	@GetMapping("/cashier/{cashierId}")
	public ResponseEntity<List<ShiftReportDto>> getShiftReportByCashier(@PathVariable Long cashierId) {
		return ResponseEntity.ok(shiftReportService.getShiftReportsByCashierId(cashierId));
	}
	
	@GetMapping("branch/{branchId}")
	public ResponseEntity<List<ShiftReportDto>> getShiftReportByBranch(@PathVariable Long branchId) {
		return ResponseEntity.ok(shiftReportService.getShiftReportsByBranchId(branchId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShiftReportDto> getShiftReportById(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(shiftReportService.getShiftReportById(id));
	}
}
