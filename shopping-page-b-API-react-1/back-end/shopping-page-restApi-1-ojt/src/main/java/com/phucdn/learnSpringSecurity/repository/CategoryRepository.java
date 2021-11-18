package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.CategoryEntity;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
	
	@Query(value = "select * from categories_of_items "
			+ "where status = 'Active'", nativeQuery = true)
	List<CategoryEntity> findAllCategoryWithActiveStatus();
}
