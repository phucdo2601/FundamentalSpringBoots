package com.phucdn.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phucdn.orderservice.model.Order;

public interface OrderRepostiory extends JpaRepository<Order, Long> {

}
