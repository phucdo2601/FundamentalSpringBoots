package com.phucdn.shoppingPage.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.phucdn.shoppingPage.dto.CartItemDTO;
import com.phucdn.shoppingPage.entity.ItemEntity;
import com.phucdn.shoppingPage.repository.ItemRepository;
import com.phucdn.shoppingPage.service.ShoppingCartService;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private Map<String, CartItemDTO> maps = new HashMap<>();
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public void addCartItem(CartItemDTO item) {
		CartItemDTO cartItem = maps.get(item.getItemId());
		if (cartItem == null) {
			maps.put(item.getItemId(), item);
		}else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	}
	
	@Override
	public void remove(String id) {
		maps.remove(id);
	}
	
	@Override
	public CartItemDTO update(String itemId, int quantity) {
		CartItemDTO cartItem = maps.get(itemId);
		cartItem.setQuantity(quantity);
		return cartItem;
	}
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	@Override
	public Collection<CartItemDTO> getAllItems() {
		return maps.values();
	}
	
	@Override
	public int count() {
		return maps.values().size();
	}
	
	@Override
	public double getAmount() {
		return maps.values().stream()
				.mapToDouble(item -> item.getPrice() * item.getQuantity())
				.sum();
	}
	
	@Override
	public CartItemDTO increaseOneQuanById(String itemId) {
		Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
		int quanItem = itemEntity.get().getQuantity();
		CartItemDTO cartItem = maps.get(itemId);
		int oldQuantityInCart = cartItem.getQuantity();
		if (oldQuantityInCart < quanItem) {
			cartItem.setQuantity(oldQuantityInCart + 1);
		}		
		return cartItem;
	}
	
	@Override
	public CartItemDTO decreaseOneQuanById(String itemId) {
		CartItemDTO cartItem = maps.get(itemId);
		int oldQuantity = cartItem.getQuantity();
		if (oldQuantity > 0) {
			cartItem.setQuantity(oldQuantity - 1);
		}	
		return cartItem;
	}
}
