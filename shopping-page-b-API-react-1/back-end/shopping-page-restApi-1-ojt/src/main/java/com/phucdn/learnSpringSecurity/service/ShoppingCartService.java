package com.phucdn.learnSpringSecurity.service;

import java.util.Collection;

import com.phucdn.learnSpringSecurity.dto.CartItemDTO;

public interface ShoppingCartService {

	CartItemDTO decreaseOneQuanById(String itemId);

	CartItemDTO increaseOneQuanById(String itemId);

	double getAmount();

	int count();

	Collection<CartItemDTO> getAllItems();

	void clear();

	CartItemDTO update(String itemId, int quantity);

	void remove(String itemId);

	void addCartItem(CartItemDTO item);

}
