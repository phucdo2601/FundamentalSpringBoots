package com.phucdn.shoppingPage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discounts")
public class DiscountEntity implements Serializable{
	@Id
	@Column(name = "discount_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String discountId;
	@Column(name = "discount_name", columnDefinition = "nvarchar(50) null")
	private String discountName;
	@Column(name = "rate_dis", columnDefinition = "float null")
	private double rateDis;
	@Column(name = "is_using", columnDefinition = "bit null")
	private boolean isUsing;
	@Column(name = "date_of_create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
}
