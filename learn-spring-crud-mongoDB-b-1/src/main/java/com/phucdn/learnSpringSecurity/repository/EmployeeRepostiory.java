package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.EmployeeEntity;

@Repository
public interface EmployeeRepostiory extends MongoRepository<EmployeeEntity, Long> {

}
