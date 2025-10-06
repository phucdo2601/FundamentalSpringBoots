package com.phucdn.model;

import java.time.LocalDateTime;
import java.util.List;

import com.phucdn.domain.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`order`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double totalAmount;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	private Branch branch;
	
	@ManyToOne
	private User cashier;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	private List<OrderItem> items;
	
	private PaymentType paymentType;
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}
}
