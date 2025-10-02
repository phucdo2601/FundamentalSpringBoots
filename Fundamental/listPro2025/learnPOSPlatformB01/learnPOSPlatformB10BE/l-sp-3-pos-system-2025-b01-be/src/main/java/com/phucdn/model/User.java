package com.phucdn.model;

import java.time.LocalDateTime;

import com.phucdn.domain.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false, unique = true)
	@Email(message = "Email should be valid")
	private String email;
	
	private String phone;
	
	@Column(nullable = false)
	private UserRole role;

	@Column(nullable = false)
	private String password;
	
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private LocalDateTime lastLogin;
	
	@ManyToOne
	private Store store;
	
	@ManyToOne
	private Branch branch;
}
