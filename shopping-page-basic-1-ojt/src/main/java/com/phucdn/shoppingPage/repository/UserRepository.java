package com.phucdn.shoppingPage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.shoppingPage.entity.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String>  {

	@Query(value = "select user_id, address, date_of_create, "
			+ "email, full_name, password, "
			+ "phone, status, role_id "
			+ "from users "
			+ "where user_id = :userId", nativeQuery = true)
	UserEntity findUserAccount(@Param("userId") String userId);
	
	@Query(value = "select * from users "
			+ "where user_id LIKE %:userId%", nativeQuery = true)
	List<UserEntity> searchUserLikeByUserId(@Param("userId") String userId);
	
}
