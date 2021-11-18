package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "booking_details")
public class BookingDetailEntity implements Serializable{
	@Id
	@Column(name = "booking_de_id", nullable = false,columnDefinition = "nvarchar(100)")
	private String bookingDeId;
	@Column(name = "item_name",columnDefinition = "nvarchar(50) null")
	private String itemName;
	@Column(name = "img_url",columnDefinition = "nvarchar(200) null")
	private String imgUrl;
	@Column(name = "quantity",columnDefinition = "int null")
	private int quantity;
	@Column(name = "price",columnDefinition = "float null")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private ItemEntity item;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private BookingEntity booking;
}
