package com.phucdn.learnSpringSecurity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;

@Repository
public interface EmployeeRepostiory extends MongoRepository<EmployeeEntity, String> {

	public List<EmployeeEntity> findByEmpIdIn(List<String> empIds);
	
	public Optional<EmployeeEntity> findByEmpId(String empId);
	
	List<EmployeeEntity> findByIdIn(List<String> empIds);
	
	@Query("{$or : [{'first_name': {$regex: :#{#search}}}, {'email_id': {$regex: :#{#search}}}]}")
	public List<EmployeeEntity> findEmployeeByFirstNameOrEmailId(@Param("search") String search);
	
	@Query("{$or : [{'first_name': {$regex: :#{#search}}}, {'email_id': {$regex: :#{#search}}}]}")
	public Page<EmployeeEntity> findEmployeeeByFirstNameOrEmailIdPaging(@Param("search") String search, Pageable pageable);
}
