package com.phucdn.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.jobportal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
