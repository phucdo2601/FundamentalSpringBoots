package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "productBrands_tbl")
public class ProductBrand extends BaseEntity implements Serializable {
	private String brandCode;
	private String brandName;
	private String description;
	private Timestamp dateOfCreate;

	@OneToMany(mappedBy = "productBrand", cascade = CascadeType.ALL)
	private List<Product> listProduct;
}
