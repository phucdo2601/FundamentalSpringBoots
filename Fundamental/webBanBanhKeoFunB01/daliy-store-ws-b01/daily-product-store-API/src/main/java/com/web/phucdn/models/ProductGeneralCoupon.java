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
@Entity(name = "productGeneralCoupons_tbl")
public class ProductGeneralCoupon extends BaseEntity implements Serializable {
	private Timestamp dateOfCreatel;
	private Timestamp dateOfUpdate;
	private boolean isUsing;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "genCouId")
	private GeneralCoupon generalCoupon;
}
