package com.phucdn.learnSpringSecurity.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.ItemEntity;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<ItemEntity, String> {

//	@Modifying
//	@Query(value = "update items set author = :author, date_of_create = :dateOfUpdate, "
//			+ "description = :description, img_url = :imgUrl, item_name = :itemName, "
//			+ "price = :price, quantity = :quantity, cate_id = :cateId "
//			+ "where item_id = :itemId", nativeQuery = true)
//	Integer updateItemByItemId(@Param("itemId") String itemId, @Param("itemName") String itemName,
//			@Param("author") String author, @Param("dateOfUpdate") Date dateOfUpdate, @Param("description") String description, 
//			@Param("imgUrl") String imgUrl, @Param("price") double price, @Param("quantity") int quantity, 
//			@Param("cateId") String cateId);
	
	@Query(value = "select * from items "
			+ "where status = 'Active'", nativeQuery = true)
	List<ItemEntity> findAllItemWithAcitveStatus();
	
}
