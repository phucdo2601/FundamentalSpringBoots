package com.example.demo.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products_tbl")
public class Product extends BaseEntity implements Serializable {
	private String productCode;
	private String productName;
	private Integer quantity;
	private String description;
	private Float originalPrice;
	private String statusId;
	private Date dateOfCreate;
	private Date dateOfUpdate;

	@ManyToOne
	@JoinColumn(name = "productBrandId")
	private ProductBrand productBrand;
}
