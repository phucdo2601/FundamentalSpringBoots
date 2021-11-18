package com.phucdn.shoppingPage.service;

import java.util.Collection;

import com.phucdn.shoppingPage.dto.CartItemDTO;

public interface ShoppingCartService {

	double getAmount();

	int count();

	Collection<CartItemDTO> getAllItems();

	void clear();

	CartItemDTO update(String itemId, int quantity);

	void remove(String id);

	void addCartItem(CartItemDTO item);

	CartItemDTO decreaseOneQuanById(String itemId);

	CartItemDTO increaseOneQuanById(String itemId);

}
