package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.dto.ItemDTO;
import com.phucdn.learnSpringSecurity.entity.CategoryEntity;
import com.phucdn.learnSpringSecurity.entity.ItemEntity;
import com.phucdn.learnSpringSecurity.exception.ItemException;
import com.phucdn.learnSpringSecurity.repository.ItemRepository;
import com.phucdn.learnSpringSecurity.service.ItemService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/items")
public class AdminItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("")
	public List<ItemDTO> loadAllItems() {
		List<ItemDTO> listItemReturn = new ArrayList<>();
		List<ItemEntity> listItem =
				itemRepository.findAllItemWithAcitveStatus();
		for (ItemEntity itemEntity : listItem) {
			String itemId = itemEntity.getItemId();
			String itemName = itemEntity.getItemName();
			String author = itemEntity.getAuthor();
			Date dateOfCreate = itemEntity.getDateOfCreate();
			String description = itemEntity.getDescription();
			String imgUrl = itemEntity.getImgUrl();
			double price = itemEntity.getPrice();
			int quantity = itemEntity.getQuantity();
			String status = itemEntity.getStatus();
			String cateId = itemEntity.getCategory().getCateId();
			listItemReturn.add(new ItemDTO(itemId, itemName, author, dateOfCreate, description, imgUrl, price, quantity, status, cateId));
		}
		return listItemReturn;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> getItemById(@PathVariable("id") String itemId) {
		ItemEntity itemEntity = itemService.findById(itemId)
				.orElseThrow(() -> new ItemException("Item does not exist with this id: " + itemId));
		ItemDTO itemDTO = new ItemDTO();
		BeanUtils.copyProperties(itemEntity, itemDTO);
		String cateId = itemEntity.getCategory().getCateId();
		itemDTO.setCateId(cateId);
		return ResponseEntity.ok(itemDTO);
	}

	@PostMapping("")
	public ItemEntity createNewItem(@RequestBody ItemDTO itemDTO) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(itemDTO, itemEntity);
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCateId(itemDTO.getCateId());
		itemEntity.setCategory(categoryEntity);
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		itemEntity.setDateOfCreate(dateOfCreate);
		itemEntity.setStatus("Active");
		itemEntity.setImgUrl("test.jpg");

		return itemService.save(itemEntity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemEntity> updateItemById(@PathVariable("id") String itemId,@RequestBody ItemDTO itemDTO) {
		ItemEntity itemEntity = itemService.findById(itemId)
				.orElseThrow(() -> new ItemException("Item does not exist with this id: " + itemId));
		BeanUtils.copyProperties(itemDTO, itemEntity);
		Long mills = System.currentTimeMillis();
		Date dateOfUpdate = new Date(mills);
		itemEntity.setDateOfCreate(dateOfUpdate);
		itemEntity.setStatus(itemDTO.getStatus());
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCateId(itemDTO.getCateId());
		itemEntity.setCategory(categoryEntity);
		itemEntity.setStatus("Active");

		System.out.println("ItemID: "+itemEntity.getItemId());
		System.out.println("ItemName: "+itemEntity.getItemName());
		System.out.println("ImgUrl: "+itemEntity.getImgUrl());
		System.out.println("Description: "+itemEntity.getDescription());
		System.out.println("Price: "+itemEntity.getPrice());
		System.out.println("Author: "+itemEntity.getAuthor());
		System.out.println("CateId: "+itemEntity.getCategory());

		ItemEntity updateItem = itemService.save(itemEntity);

		return ResponseEntity.ok(updateItem);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoleOfUser(@PathVariable("id") String itemId) {
		ItemEntity itemEntity = itemService.findById(itemId)
				.orElseThrow(() -> new ItemException("Item does not exist with this id: " + itemId));
		itemService.delete(itemEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

	@PutMapping("/delO/{id}")
	public ResponseEntity<ItemEntity> deleteRoleOfUserOriginal(@PathVariable("id") String itemId) {
		ItemEntity itemEntity = itemService.findById(itemId)
				.orElseThrow(() -> new ItemException("Item does not exist with this id: " + itemId));

		itemEntity.setStatus("InActive");

		ItemEntity deleteItemO = itemService.save(itemEntity);

		return ResponseEntity.ok(deleteItemO);
	}
}
