package com.phucdn.shoppingPage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.shoppingPage.entity.BookingDetailEntity;

@Repository
@Transactional
public interface BookingDetailRepository extends JpaRepository<BookingDetailEntity, String> {
	
	@Query(value = "select booking_de_id, img_url, item_name, quantity, booking_id, item_id,price\r\n"
			+ "from booking_details\r\n"
			+ "where booking_id = :bookingId", nativeQuery = true)
	List<BookingDetailEntity> findBookingDetailByBookingId(@Param("bookingId") String bookingId);
}
