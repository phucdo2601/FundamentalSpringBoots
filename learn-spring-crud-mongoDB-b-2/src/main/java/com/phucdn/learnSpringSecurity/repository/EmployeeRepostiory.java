package com.phucdn.learnSpringSecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;

@Repository
public interface EmployeeRepostiory extends MongoRepository<EmployeeEntity, String> {

	public Optional<EmployeeEntity> findByEmpId(String empId);
}
