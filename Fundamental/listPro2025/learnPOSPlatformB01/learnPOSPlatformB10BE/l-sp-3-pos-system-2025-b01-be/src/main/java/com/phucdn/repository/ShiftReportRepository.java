package com.phucdn.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.model.ShiftReport;
import com.phucdn.model.User;

@Repository
public interface ShiftReportRepository extends JpaRepository<ShiftReport, Long> {
	List<ShiftReport> findByCashierId(Long cashierId);
	
	List<ShiftReport> findByBranchId(Long branchId);
	
	Optional<ShiftReport> findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(User cashier);
	
	Optional<ShiftReport> findByCashierAndShiftStartBetween(User cashier, LocalDateTime start, LocalDateTime end);
}
