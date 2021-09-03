package com.phucdn.learnSpringJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringJPA.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
