package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "carts_tbl")
public class Cart extends BaseEntity implements Serializable {
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;
	private Float subTotal;
	private Float tax;
	private Float total;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> listCartItems;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Order> listOrders;
}
