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
@Entity(name = "generalCoupons_tbl")
public class GeneralCoupon extends BaseEntity implements Serializable {
	private String genCouCode;
	private String genCouTitle;
	private Float value;
	private String unitOfValue;
	private Timestamp dateOfCreate;
	private Timestamp dateOfBegin;
	private Timestamp dateOfEnd;
	private Timestamp dateOfUpdate;
	private String statusId;

	@ManyToOne
	@JoinColumn(name = "genCouTypeId")
	private CouponGeneralType couponGeneralType;

	@OneToMany(mappedBy = "generalCoupon", cascade = CascadeType.ALL)
	private List<ProductGeneralCoupon> listProductGeneralCoupons;
}
