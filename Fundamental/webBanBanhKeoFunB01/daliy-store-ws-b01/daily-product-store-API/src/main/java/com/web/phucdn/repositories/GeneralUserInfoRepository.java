package com.web.phucdn.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.phucdn.models.GeneralUserInfo;

@Repository
public interface GeneralUserInfoRepository extends BaseRepository<GeneralUserInfo> {

	@Query(value = "select * from general_user_info_tbl where user_name = :userName and password = :password", nativeQuery = true)
	public GeneralUserInfo getUserByUserNameAndPassword(@Param("userName") String userName,
			@Param("password") String password);

	public Optional<GeneralUserInfo> findByUserName(String userName);
}
