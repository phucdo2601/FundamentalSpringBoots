package com.phucdn.shoppingPage.entity;

import java.io.Serializable;

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
@Table(name = "bookingDetails")
public class BookingDetailEntity implements Serializable{
	@Id
	@Column(name = "bookingDe_id", nullable = false,columnDefinition = "nvarchar(100)")
	private String bookingDeId;
	@Column(name = "item_name", columnDefinition = "nvarchar(50) null")
	private String itemName;
	@Column(name = "img_url", columnDefinition = "nvarchar(200) null")
	private String imgUrl;
	@Column(name = "quantity", columnDefinition = "int null")
	private int quantity;
	@Column(name = "price", columnDefinition = "float null")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private BookingEntity booking;
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private ItemEntity item;
}
