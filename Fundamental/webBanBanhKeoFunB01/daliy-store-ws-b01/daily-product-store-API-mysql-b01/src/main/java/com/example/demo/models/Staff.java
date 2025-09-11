package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "staffs_tbl")
public class Staff extends BaseEntity implements Serializable {
	private String staffCode;

	/**
	 * How to make relation ahip one to one (O-n-O) in Java Spring JPA In this
	 * example: I will choose table GeneralUserInfo and Customer: - Customer is the
	 * main table -> Therefore, the Customer has foreignKey of GeneralUserInfo table
	 */
	@OneToOne
	@JoinColumn(name = "genUserInfoId")
	private GeneralUserInfo generalUserInfo;
}
