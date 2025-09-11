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
@Entity(name = "products_tbl")
public class Product extends BaseEntity implements Serializable {
	private String productCode;
	private String productName;
	private Integer quantity;
	private String description;
	private Float originalPrice;
	private String statusId;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;

	@ManyToOne
	@JoinColumn(name = "productBrandId")
	private ProductBrand productBrand;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductDetails> listProductDe;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductImage> listProductImages;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductProductCate> listProductProductCates;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductGeneralCoupon> listProductGeneralCoupons;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<CartItem> listCartItems;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderItem> listOrderItems;
}
