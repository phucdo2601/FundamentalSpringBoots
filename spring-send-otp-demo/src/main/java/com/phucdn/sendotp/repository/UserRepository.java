package com.phucdn.sendotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.sendotp.domain.UserPojo;

@Repository
public interface UserRepository extends JpaRepository<UserPojo, String> {
	UserPojo findByUsername(String username);
}
