package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "bookings")
public class BookingEntity implements Serializable{
	@Id
	@Column(name = "booking_id", nullable = false, columnDefinition = "nvarchar(100)")
	private String bookingId;
	@Column(name = "address", columnDefinition = "ntext null")
	private String address;
	@Column(name = "discount_id", columnDefinition = "nvarchar(50) null")
	private String discountId;
	@Column(name = "date_of_create", columnDefinition = "datetime null")
	private Date dateOfCreate;
	@Column(name = "email", columnDefinition = "nvarchar(50) null")
	private String email;
	@Column(name = "full_name", columnDefinition = "nvarchar(50) null")
	private String fullName;
	@Column(name = "phone", columnDefinition = "nvarchar(50) null")
	private String phone;
	@Column(name = "payment_method", columnDefinition = "nvarchar(50) null")
	private String paymentMethod;
	@Column(name = "date_of_process", columnDefinition = "datetime null")
	private Date dateOfProcess;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	@Column(name = "date_of_finish", columnDefinition = "datetime null")
	private Date dateOfFinish;
	@Column(name = "sub_total", columnDefinition = "float null")
	private double subTotal;
	@Column(name = "shipping", columnDefinition = "float null")
	private double shipping;
	@Column(name = "tax", columnDefinition = "float null")
	private double tax;
	@Column(name = "total", columnDefinition = "float null")
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@OneToMany(mappedBy = "booking")
	@JsonIgnore
	private Set<BookingDetailEntity> listBookingDe;
}
