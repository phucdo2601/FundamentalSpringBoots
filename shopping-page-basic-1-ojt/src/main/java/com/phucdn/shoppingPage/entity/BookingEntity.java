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
@Table(name = "bookings")
public class BookingEntity implements Serializable{
	@Id
	@Column(name = "booking_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String bookingId;
	@Column(name = "full_name", columnDefinition = "nvarchar(50) null")
	private String fullname;
	@Column(name = "phone", columnDefinition = "nvarchar(20) null")
	private String phone;
	@Column(name = "email", columnDefinition = "nvarchar(50) null")
	private String email;
	@Column(name = "address", columnDefinition = "nvarchar(200) null")
	private String address;
	@Column(name = "date_of_create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "discount_id", columnDefinition = "nvarchar(50) null")
	private String discountId;
	@Column(name = "payment_method", columnDefinition = "nvarchar(50) null")
	private String paymentMethod;
	@Column(name = "sub_total", columnDefinition = "float null")
	private double subTotal;
	@Column(name = "shipping", columnDefinition = "float null")
	private double shipping;
	@Column(name = "tax", columnDefinition = "float null")
	private double tax;
	@Column(name = "total", columnDefinition = "float null")
	private double total;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@OneToMany(mappedBy = "booking")
	private Set<BookingDetailEntity> listBookingDetail;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
}
