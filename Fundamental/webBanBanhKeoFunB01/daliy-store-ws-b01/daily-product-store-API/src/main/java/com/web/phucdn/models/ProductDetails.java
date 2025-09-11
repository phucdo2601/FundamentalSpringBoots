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
@Entity(name = "productDetails_tbl")
public class ProductDetails extends BaseEntity implements Serializable {
	private String productDeCode;
	private String productDeTitle;
	private String productDeContent;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
}
