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
@Entity(name = "productImages")
public class ProductImage extends BaseEntity implements Serializable {
	private String productImageCode;
	private String productImageTitle;
	private Timestamp dateOfCreate;
	private String statusId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
}
