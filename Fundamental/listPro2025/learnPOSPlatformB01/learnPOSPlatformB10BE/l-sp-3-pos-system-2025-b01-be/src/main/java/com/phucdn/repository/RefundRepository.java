package com.phucdn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.model.Refund;
import com.phucdn.model.User;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {

	List<Refund> findByCashierIdAndCreatedAtBetween(Long cashierId, LocalDateTime from, LocalDateTime to);
	
	List<Refund> findByCashierId(Long cashierId);
	
	List<Refund> findByShiftReportId(Long id);
	
	List<Refund> findByBranchId(Long id);
}
