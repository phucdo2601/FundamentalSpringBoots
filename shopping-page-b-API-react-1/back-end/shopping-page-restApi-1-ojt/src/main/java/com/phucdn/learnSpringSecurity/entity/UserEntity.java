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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "users")
public class UserEntity implements Serializable{
	@Id
	@Column(name = "user_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String userId;
	@Column(name = "password", columnDefinition = "nvarchar(200) null")
	private String password;
	@Column(name = "full_name", columnDefinition = "nvarchar(50) null")
	private String fullName;
	@Column(name = "phone", columnDefinition = "nvarchar(50) null")
	private String phone;
	@Column(name = "email", columnDefinition = "nvarchar(50) null")
	private String email;
	@Column(name = "address", columnDefinition = "nvarchar(50) null")
	private String address;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	@Temporal(TemporalType.DATE)
	private Date dateOfCreate;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private RoleOfUserEntity roleUser;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<DiscountUserEntity> listDiscount;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<BookingEntity> listBooking;
}
