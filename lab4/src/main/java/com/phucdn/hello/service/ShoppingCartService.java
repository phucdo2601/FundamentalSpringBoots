package com.phucdn.hello.service;

import java.util.Collection;

import com.phucdn.hello.model.CartObj;

public interface ShoppingCartService {

	int getCount();

	double getAmount();

	void update(int productID, int quantity);

	void clear();

	Collection<CartObj> getCartItems();

	void remove(int productID);

	void add(CartObj item);

}
