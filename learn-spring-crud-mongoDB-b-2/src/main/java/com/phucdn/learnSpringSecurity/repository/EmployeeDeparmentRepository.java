package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.EmployeeDeparmentEntity;

@Repository
public interface EmployeeDeparmentRepository extends MongoRepository<EmployeeDeparmentEntity, String> {

}
