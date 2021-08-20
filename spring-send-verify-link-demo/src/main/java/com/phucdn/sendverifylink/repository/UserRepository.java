package com.phucdn.sendverifylink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.sendverifylink.domain.UserEntity;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByEmailIdIgnoreCase(String emailId);
}
