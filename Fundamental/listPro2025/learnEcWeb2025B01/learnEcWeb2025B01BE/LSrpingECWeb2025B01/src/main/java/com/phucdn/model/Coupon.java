package com.phucdn.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String code;

	private double discountPercentage;
	
	private LocalDate validityStartDate;
	
	private LocalDate validityEndDate;
	
	private double minimunOrderValue;
	
	private boolean isActivate = true;
	
	@ManyToMany(mappedBy = "usedCoupons")
	private Set<User> usedByUsers = new HashSet<>();
}
