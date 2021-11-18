package com.phucdn.shoppingPage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.shoppingPage.entity.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {

	@Modifying
	@Query(value = "update categories set status = 0 where cate_id = ?1", nativeQuery = true)
	void updateCategoryStatusByCategoryId(String cateId);
	
	@Modifying
	@Query(value = "update categories set cate_name = :cateName, "
			+ "date_Of_Create = :dateOfCreate "
			+ "where cate_id = :cateId", nativeQuery = true)
	void updateCategoryByCategoryId(@Param("cateId") String cateId, @Param("cateName") String cateName,
			@Param("dateOfCreate") Date dateOfCreate);
	
	@Query(value = "select * from categories "
			+ "where cate_id LIKE %:cateId%", nativeQuery = true)
	List<Category> searchCategoryLikeByCateId(@Param("cateId") String cateId);
}
