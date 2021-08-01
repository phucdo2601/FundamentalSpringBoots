package com.phucdn.hello.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.phucdn.hello.model.CartObj;
import com.phucdn.hello.service.ShoppingCartService;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private Map<Integer, CartObj> map = new HashMap<>();

	@Override
	public void add(CartObj item) {
		CartObj existedItem = map.get(item.getProductID());
		if (existedItem != null) {
			existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
		} else {
			map.put(item.getProductID(), item);
		}
	}

	@Override
	public void remove(int productID) {
		map.remove(productID);
	}

	@Override
	public Collection<CartObj> getCartItems() {
		return map.values();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public void update(int productID, int quantity) {
		CartObj item = map.get(productID);
//		item.setQuantity(quantity + item.getQuantity());
		item.setQuantity(quantity);
		if (item.getQuantity() <= 0) {
			map.remove(productID);
		}
	}
	
	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
	}
	
	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}
}
