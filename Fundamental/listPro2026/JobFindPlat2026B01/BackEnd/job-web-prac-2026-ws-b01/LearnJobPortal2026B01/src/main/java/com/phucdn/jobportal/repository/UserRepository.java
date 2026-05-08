package com.phucdn.jobportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.jobportal.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
