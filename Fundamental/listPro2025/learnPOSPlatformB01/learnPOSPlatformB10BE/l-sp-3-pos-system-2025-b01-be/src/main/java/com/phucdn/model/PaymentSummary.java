package com.phucdn.model;

import com.phucdn.domain.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PaymentSummary {
	private PaymentType paymentType;
	private Double totalAmount;
	private int transactionCount;
	private double percentage;
}
