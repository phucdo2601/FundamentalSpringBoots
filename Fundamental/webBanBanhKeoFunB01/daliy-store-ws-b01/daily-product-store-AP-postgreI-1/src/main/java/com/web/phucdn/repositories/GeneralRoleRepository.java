package com.web.phucdn.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.phucdn.models.GeneralRole;

@Repository
public interface GeneralRoleRepository extends BaseRepository<GeneralRole> {

	/**
	 * Native query in Spring data JPA
	 * 
	 * @param genRoleId
	 * @return
	 */
	@Query(value = "SELECT * FROM general_roles_tbl WHERE id =:genRoleId", nativeQuery = true)
	public GeneralRole findGeneralRoleByGenRoleId(@Param("genRoleId") UUID genRoleId);

	/**
	 * JPQL query
	 * 
	 * @return
	 */
	@Query(value = "SELECT o from generalRoles_tbl o where o.genRoleCode like '%cus%'")
	public GeneralRole findCustomerRoleOfGenRole();

	@Query(value = "SELECT * FROM general_roles_tbl where gen_role_code like '%ss%' or gen_role_title like '%Staff%'", nativeQuery = true)
	public GeneralRole findStaffRoleOfGenRole();
}
