package com.example.demo.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers_tbl")
public class Customer extends BaseEntity implements Serializable {
	private String customerCode;
	private Float customerPoint;
	private Date lastPurchaseDate;

	/**
	 * How to make relation ahip one to one (O-n-O) in Java Spring JPA In this
	 * example: I will choose table GeneralUserInfo and Customer: - Customer is the
	 * main table -> Therefore, the Customer has foreignKey of GeneralUserInfo table
	 */
	@OneToOne
	@JoinColumn(name = "genUserInfoId")
	private GeneralUserInfo generalUserInfo;
}
