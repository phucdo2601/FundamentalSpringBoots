package com.phucdn.learnSpringSecurity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String>{

	// Dang 1: viet voi cac dong tu ghep lai theo quy tac cua mongDB trong spring
	public Optional<DepartmentEntity> findByDepId(String depId);
	
	@Query("{'status' : 'Activate'}")
	public List<DepartmentEntity> getAllDepartmentWithActivateStatus();
	
	public List<DepartmentEntity> findByDepIdIn(List<String> ids);
}
