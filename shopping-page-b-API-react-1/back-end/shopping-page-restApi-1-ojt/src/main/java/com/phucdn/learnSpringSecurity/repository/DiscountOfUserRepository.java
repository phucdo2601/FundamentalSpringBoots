package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.DiscountOfUserEntity;

@Repository
@Transactional
public interface DiscountOfUserRepository extends JpaRepository<DiscountOfUserEntity, String> {

	@Query(value = "select * from discounts_of_users "
			+ "where status = 'Active'", nativeQuery = true)
	List<DiscountOfUserEntity> findAllDiscountOfUserWithAcitveStatus();
	
	@Modifying
	@Query(value = "update discounts_of_users "
			+ "set status = 'Active' "
			+ "where discount_id = :discountId", nativeQuery = true)
	Integer reActivateDiscount(@Param("discountId") String discountId);
}
