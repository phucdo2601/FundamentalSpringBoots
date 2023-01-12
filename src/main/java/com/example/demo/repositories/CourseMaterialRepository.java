package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.CourseMaterialEntity;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterialEntity, Long>{

}
