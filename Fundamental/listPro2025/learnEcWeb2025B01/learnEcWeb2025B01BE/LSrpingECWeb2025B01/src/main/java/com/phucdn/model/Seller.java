package com.phucdn.model;

import com.phucdn.domain.AccountStatus;
import com.phucdn.domain.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String sellerName;
	
	private String mobile;;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private String password;
	
	@Embedded
	private BusinessDetails BusinessDetails = new BusinessDetails();

	@Embedded
	private BankDetails bankDetails = new BankDetails();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address pickupAddress = new Address();

	private String GSTIN;
	
	private UserRole role = UserRole.ROLE_SELLER;
	
	private boolean isEmailVerified = false;
	
	private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;
}
