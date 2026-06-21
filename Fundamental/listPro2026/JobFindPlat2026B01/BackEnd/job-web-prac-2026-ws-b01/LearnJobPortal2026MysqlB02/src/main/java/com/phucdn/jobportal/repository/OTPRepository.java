package com.phucdn.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.jobportal.entity.OTP;
import java.time.LocalDateTime;


@Repository
public interface OTPRepository extends JpaRepository<OTP, String> {

	List<OTP> findByCreationTimeBefore(LocalDateTime expiry);
}
