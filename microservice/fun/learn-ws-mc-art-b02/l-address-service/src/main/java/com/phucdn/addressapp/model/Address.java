package com.phucdn.addressapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name="lane1", columnDefinition = "varchar(45)")
	private String lane1;
	@Column(name = "lane2", columnDefinition = "varchar(45)")
	private String lane2;
	@Column(name = "state", columnDefinition = "varchar(45)")
	private String state;
	@Column(name = "zip", columnDefinition = "varchar(45)")
	private String zip;
}
