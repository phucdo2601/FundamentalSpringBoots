package com.example.demo.models;

import java.io.Serializable;
import java.sql.Date;
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
	private Date dateOfCreate;

	@OneToMany(mappedBy = "productBrand", cascade = CascadeType.ALL)
	private List<Product> lisProducts;
}
