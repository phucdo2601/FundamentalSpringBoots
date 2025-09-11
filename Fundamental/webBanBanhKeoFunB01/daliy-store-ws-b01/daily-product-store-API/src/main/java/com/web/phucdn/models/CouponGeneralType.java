package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "generalCouponType_tbl")
public class CouponGeneralType extends BaseEntity implements Serializable {
	private String couGenTypeCode;
	private String couGenTypeTitle;
	private Timestamp dateOfCreate;
	private String statusId;
	private Timestamp dateOfUpdate;

	@OneToMany(mappedBy = "couponGeneralType", cascade = CascadeType.ALL)
	@JsonManagedReference // Handles the forward reference
	private List<GeneralCoupon> listGeneralCoupons;
}
