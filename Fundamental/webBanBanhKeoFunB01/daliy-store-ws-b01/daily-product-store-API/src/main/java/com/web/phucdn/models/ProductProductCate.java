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
@Entity(name = "productProductCates_tbl")
public class ProductProductCate extends BaseEntity implements Serializable {
	private Timestamp dateOfCreate;
	private String statusId;
	private Timestamp dateOfUpdate;

	@ManyToOne
	@JoinColumn(name = "productId", nullable = true)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "proCateId", nullable = true)
	private ProductCategory productCategory;
}
