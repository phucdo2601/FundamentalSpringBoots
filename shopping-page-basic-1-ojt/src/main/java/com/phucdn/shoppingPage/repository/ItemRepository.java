package com.phucdn.shoppingPage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.shoppingPage.entity.ItemEntity;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
	@Modifying
	@Query(value = "update items set status = ?1 where item_id = ?2", nativeQuery = true)
	void updateItemStatusByItemId(String status, String itemId);
	
	@Modifying
	@Query(value = "update items set item_name = :itemName, cate_id = :cateId, "
			+ "author = :author, price = :price, "
			+ "quantity = :quantity, description = :description "
			+ "where item_id = :itemId", nativeQuery = true)
	void updateItemByItemId(@Param("itemId") String itemId, @Param("itemName") String itemName,
			@Param("cateId") String cateId, @Param("author") String author,
			@Param("price") double price, @Param("quantity") int quantity,
			@Param("description") String description);
	
	@Query(value = "select item_id, author, date_of_create, description, "
			+ "img_url, item_name, price, "
			+ "quantity, status, cate_id "
			+ "from items "
			+ "where cate_id = :cateId", nativeQuery = true)
	List<ItemEntity> loadRecommendItemsByCateId(@Param("cateId") String cateId);
	
	@Query(value = "select item_id, author, date_of_create, description, "
			+ "img_url, item_name, price, "
			+ "quantity, status, cate_id "
			+ "from items "
			+ "where cate_id = :cateId", nativeQuery = true)
	List<ItemEntity> loadItemsByCateId(@Param("cateId") String cateId);
	
	@Query(value = "select * from items "
			+ "where item_id LIKE %:itemId%", nativeQuery = true)
	List<ItemEntity> searchItemLikeByItemId(@Param("itemId") String itemId);
	
	@Query(value = "select top 1 * from items "
			+ "where quantity > 0 and [status] = 'Active'\n"
            + "order by date_of_create desc", nativeQuery = true)
	ItemEntity getLastItem();
}
