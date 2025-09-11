package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customes_tbl")
public class Customer extends BaseEntity implements Serializable {
	private String customerCode;
	private Float customerPoint;
	private Timestamp lastPurchaseDate;

	/**
	 * How to make relation ahip one to one (O-n-O) in Java Spring JPA In this
	 * example: I will choose table GeneralUserInfo and Customer: - Customer is the
	 * main table -> Therefore, the Customer has foreignKey of GeneralUserInfo table
	 */
	@OneToOne
	@JoinColumn(name = "genUserInfoId")
	private GeneralUserInfo generalUserInfo;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<CustomerHistoryRank> listCustomerHistoryRanks;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Cart> listCarts;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> listOrders;
}
