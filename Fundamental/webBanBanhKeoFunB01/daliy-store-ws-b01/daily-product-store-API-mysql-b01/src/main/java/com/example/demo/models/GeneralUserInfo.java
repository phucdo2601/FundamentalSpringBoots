package com.example.demo.models;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "generalUserInfo_tbl")
public class GeneralUserInfo extends BaseEntity implements Serializable {
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Date dateOfBirth;
	private String gender;
	private String address;
	private Date dateOfCreate;
	private Date dateOfLastUpdate;
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "genRoleId")

	/**
	 * @JsonManagedReference and @JsonBackReference to manage the serialization
	 *                       manually: it will skip serialization of the field
	 *                       annotated with @JsonBackReference
	 */
	@JsonBackReference
	private GeneralRole generalRole;

	/**
	 * How to make relation ahip one to one (O-n-O) in Java Spring JPA In this
	 * example: I will choose table GeneralUserInfo and Customer: - Customer is the
	 * main table -> Therefore, the Customer has foreignKey of GeneralUserInfo table
	 * 
	 * => Class GeneralUserInfo has mappedBy the manual definition on the other
	 * class has the foreign key of this table
	 */
	@OneToOne(mappedBy = "generalUserInfo")
	@JsonBackReference
	private Customer customer;

	@OneToOne(mappedBy = "generalUserInfo")
	@JsonBackReference
	private Staff staff;
}
