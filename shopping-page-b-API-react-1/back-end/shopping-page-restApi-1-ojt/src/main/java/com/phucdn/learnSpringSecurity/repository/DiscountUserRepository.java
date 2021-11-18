package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.DiscountUserEntity;

@Repository
public interface DiscountUserRepository extends JpaRepository<DiscountUserEntity, Integer> {

}
