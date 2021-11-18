package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "items")
public class ItemEntity implements Serializable{
	@Id
	@Column(name = "item_id", nullable = false, columnDefinition = "nvarchar(50)")
	private String itemId;
	@Column(name = "item_name", columnDefinition = "nvarchar(100) null")
	private String itemName;
	@Column(name = "author", columnDefinition = "nvarchar(100) null")
	private String author;
	@Column(name = "date_of_create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "description", columnDefinition = "ntext null")
	private String description;
	@Column(name = "img_url", columnDefinition = "nvarchar(255) null")
	private String imgUrl;
	@Column(name = "price", columnDefinition = "float null")
	private double price;
	@Column(name = "quantity", columnDefinition = "int null")
	private int quantity;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "cate_id", nullable = false)
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private Set<BookingDetailEntity> listBooking;
}
