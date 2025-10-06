package com.phucdn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.model.Order;
import com.phucdn.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCustomerId(Long customerId);
	List<Order> findByBrandId(Long branchId);
	List<Order> findByCashierId(Long cashierId);
	List<Order> findByBranchIdAndCreatedAtBetween(Long branchId, LocalDateTime from, LocalDateTime to);
	List<Order> findByCashierAndCreatedAtBetween(User cashier, LocalDateTime from, LocalDateTime to);
	List<Order> findTop5ByBranchIdOrderByCreatedAtDesc(Long branchId);
}
