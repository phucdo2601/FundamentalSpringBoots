package com.phucdn.shoppingPage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.shoppingPage.entity.BookingEntity;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<BookingEntity, String> {
	
	@Query(value = "select [discount_id] "
			+ "from bookings "
			+ "where [discount_id] = :discountId", nativeQuery = true)
	String checkDiscountOnBooking(@Param("discountId") String discountId);

	@Query(value = "select * from bookings "
			+ "where booking_id LIKE %:bookingId%", nativeQuery = true)
	List<BookingEntity> searchBookingLikeByBookingId(@Param("bookingId") String bookingId);
	
	@Query(value = "select * from bookings "
			+ "where user_id LIKE %:userId%", nativeQuery = true)
	List<BookingEntity> searchBookingLikeByUserId(@Param("userId") String userId);
}
