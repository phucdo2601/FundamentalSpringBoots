package com.phucdn.shoppingPage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category implements Serializable {
	@Id
	@Column(name = "cate_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String cateId;
	@Column(name = "cate_name", columnDefinition = "nvarchar(50) null")
	private String cateName;
	@Column(name = "date_Of_Create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "status", columnDefinition = "bit null")
	private boolean status;
	
	@OneToMany(mappedBy = "category")
	private Set<ItemEntity> items;
}
