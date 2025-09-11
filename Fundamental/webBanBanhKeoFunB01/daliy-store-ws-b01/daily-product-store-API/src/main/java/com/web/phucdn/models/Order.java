package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders_tbl")
public class Order extends BaseEntity implements Serializable {
	private String orderStatusId;
	private Float subTotal;
	private Float tax;
	private Float shippingFee;
	private Float savingPoint;
	private Timestamp dateOfCreate;
	private Timestamp dateOfEstimateGetPack;
	private Timestamp dateOfLastUpdate;
	private Timestamp dateOfGetPackage;
	private String description;
	private String staffId;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> listOrderItems;

	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	/**
	 * Make One to One (O-n-O) between order and payment method, Order is the main
	 * table
	 */
	@OneToOne
	@JoinColumn(name = "paymentMethodId")
	private PaymentMethod paymentMethod;
}
