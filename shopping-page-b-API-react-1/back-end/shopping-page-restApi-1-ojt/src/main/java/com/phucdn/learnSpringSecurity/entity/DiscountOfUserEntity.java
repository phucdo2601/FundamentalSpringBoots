package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discounts_of_users")
public class DiscountOfUserEntity implements Serializable{
	@Id
	@Column(name = "discount_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String discountId;
	@Column(name = "discount_name", columnDefinition = "nvarchar(50) null")
	private String discountName;
	@Column(name = "rate_dis", columnDefinition = "float null")
	private double rateDis;
	@Column(name = "date_of_create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "description", columnDefinition = "ntext null")
	private String description;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@OneToMany(mappedBy = "discount")
	@JsonIgnore
	private Set<DiscountUserEntity> listUser;
}
