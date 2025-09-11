package com.web.phucdn.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.phucdn.models.StaffRole;

@Repository
public interface StaffRoleRepository extends BaseRepository<StaffRole> {
	@Query(value = "select * from staff_roles_tbl where staff_role_code like '%se%'", nativeQuery = true)
	StaffRole getDefaultStaffRole();
}
