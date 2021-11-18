package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.RoleOfUserEntity;

@Repository
public interface RoleOfUserRepository extends JpaRepository<RoleOfUserEntity, String> {

}
