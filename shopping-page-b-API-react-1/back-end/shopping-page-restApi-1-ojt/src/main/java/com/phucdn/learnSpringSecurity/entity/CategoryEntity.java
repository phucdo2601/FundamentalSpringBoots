package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories_of_items")
public class CategoryEntity implements Serializable{
	@Id
	@Column(name = "cate_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String cateId;
	@Column(name = "cate_name", columnDefinition = "nvarchar(50) null")
	private String cateName;
	@Column(name = "date_of_create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "description", columnDefinition = "ntext null")
	private String description;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private Set<ItemEntity> items;
}
