package com.phucdn.hello.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phucdn.hello.model.Product;
import com.phucdn.hello.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
private static List<Product> list = new ArrayList<>();
	
	static {
		list.add(new Product(1, "Hat", 20, 200));
		list.add(new Product(2, "Shoes", 20, 200));
		list.add(new Product(3, "Jeans", 20, 200));
		list.add(new Product(4, "T-Shirt", 20, 200));
		list.add(new Product(5, "Skirt", 20, 200));
		list.add(new Product(6, "Coat", 20, 200));
	}
	
	@Override
	public void add(Product product) {
		list.add(product);
	}
	
	@Override
	public void remove(int productID) {
		list.removeIf(item->item.getProductID() == productID);
	}
	
	@Override
	public List<Product> findAll(){
		return list;
	}
	
	@Override
	public Product findByID(int productID) {
		Optional<Product> opt = list.stream().filter(item->item.getProductID() == productID).findFirst();
		if (opt.isPresent()) {
			return opt.get();
		}
		return list.get(productID);
	}
	
	@Override
	public void update(Product product) {
		for (int i=0; i < list.size(); i++) {
			Product item = list.get(i);
			if (item.getProductID() == product.getProductID()) {
				list.set(i, product);
				break;
			}
		}
	}
}
