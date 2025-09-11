package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cartItems_tbl")
public class CartItem extends BaseEntity implements Serializable {
	private Integer quantity;
	private Float originalPrice;
	private Float finalPrice;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;

	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
}
