package com.phucdn.jobportal.entity;

import java.time.LocalDateTime;

import com.phucdn.jobportal.dto.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otps")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OTP {
	@Id
	private String email;
	private String otpCodeString;
	private LocalDateTime creationTime;
}
