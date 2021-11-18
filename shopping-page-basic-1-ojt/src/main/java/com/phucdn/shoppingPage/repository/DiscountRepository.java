package com.phucdn.shoppingPage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.shoppingPage.entity.DiscountEntity;

@Repository
@Transactional
public interface DiscountRepository extends JpaRepository<DiscountEntity, String> {
	
	@Modifying
	@Query(value = "update discounts set status = 'InActive' where discount_id = ?1", nativeQuery = true)
	void updateDiscountStatusByDiscountId(String discountId);
	
	@Modifying
	@Query(value = "update discounts set discount_name = :disName, "
			+ "rate_dis = :rateDis, date_of_create = :dateOfCreate, "
			+ "user_id = :userId "
			+ "where discount_id = :disId", nativeQuery = true)
	void updateDiscountByDiscountId(@Param("disId") String discountId, @Param("disName") String disName,
				@Param("rateDis") double rateDis, @Param("dateOfCreate") Date dateOfCreate,
				@Param("userId") String userId);
	
	@Query(value = "select [user_id], [discount_id], [discount_name], "
			+ "[is_using], [rate_dis], [status], "
			+ "[date_of_create]\r\n"
			+ "from discounts "
			+ "where user_id = :userId", nativeQuery = true)
	List<DiscountEntity> getDiscountByUserId(@Param("userId") String userId);
	
	@Query(value = "select * from discounts "
			+ "where discount_id LIKE %:discountId%", nativeQuery = true)
	List<DiscountEntity> searchDiscountLikeByDisId(@Param("discountId") String discountId);
}
