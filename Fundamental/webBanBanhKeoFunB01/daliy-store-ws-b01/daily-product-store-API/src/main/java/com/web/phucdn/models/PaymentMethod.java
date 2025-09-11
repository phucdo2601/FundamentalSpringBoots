package com.web.phucdn.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paymentMethods_tbl")
public class PaymentMethod extends BaseEntity implements Serializable {
	private String paymentMethodCode;
	private String paymentMethodTitle;

	@OneToOne(mappedBy = "paymentMethod")
	private Order order;
}
