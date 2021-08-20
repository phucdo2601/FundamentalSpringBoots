package com.phucdn.sendverifylink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.sendverifylink.domain.ConfirmationTokenEntity;

@Repository("confirmationTokenRepository")
public interface ConfirmationTokenEntityRepository extends JpaRepository<ConfirmationTokenEntity, String>{
	ConfirmationTokenEntity findByConfirmationToken(String confirmationToken);
}
