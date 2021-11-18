package com.phucdn.shoppingPage.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity implements Serializable{
	@Id
	@Column(name = "item_id", columnDefinition = "nvarchar(50)")
	private String itemId;
	@Column(name = "item_name", columnDefinition = "nvarchar(50) null")
	private String itemName;
	@Column(name = "author", columnDefinition = "nvarchar(50) null")
	private String author;
	@Column(name = "quantity", columnDefinition = "int null")
	private int quantity;
	@Column(name = "img_url", columnDefinition = "nvarchar(200) null")
	private String imgUrl;
	@Column(name = "price", columnDefinition = "float null")
	private double price;
	@Column(name = "date_of_create", columnDefinition = "datetime null")
	private Date dateOfCreate;
	@Column(name = "description", columnDefinition = "nvarchar(200) null")
	private String description;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "cate_id", nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "item")
	private Set<BookingDetailEntity> listBookingDetail;
}
