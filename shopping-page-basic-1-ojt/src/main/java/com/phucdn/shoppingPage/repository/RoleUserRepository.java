package com.phucdn.shoppingPage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.phucdn.shoppingPage.entity.RoleUserEntity;

@Repository
@Transactional
public interface RoleUserRepository extends JpaRepository<RoleUserEntity, String>{
	
	@Query(value = "select user_roles.role_name \r\n"
			+ "from user_roles, users\r\n"
			+ "where user_roles.role_id = users.role_id and\r\n"
			+ "users.user_id = :userId", nativeQuery = true)
	List<String> getRoleNames(@Param("userId") String userId);
	
	@Query(value = "select user_roles.role_id \r\n"
			+ "from user_roles, users\r\n"
			+ "where user_roles.role_id = users.role_id and\r\n"
			+ "users.user_id = :userId", nativeQuery = true)
	List<String> getRoleIDs(@Param("userId") String userId);
}
