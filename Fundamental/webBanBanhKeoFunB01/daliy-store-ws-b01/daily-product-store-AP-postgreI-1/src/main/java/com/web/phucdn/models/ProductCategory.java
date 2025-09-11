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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "productCategories_tbl")
public class ProductCategory extends BaseEntity implements Serializable {
	private String proCateCode;
	private String proCateTitle;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	private List<ProductProductCate> lisProductProductCates;
}
