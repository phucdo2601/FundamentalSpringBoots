package com.phucdn.shoppingPage.validator;

import java.util.Optional;

import org.thymeleaf.util.StringUtils;

import com.phucdn.shoppingPage.entity.ItemEntity;



public class ItemValidator {

	public boolean isValid(ItemEntity item) {
		return Optional.ofNullable(item)
				.filter(t -> !StringUtils.isEmpty(t.getItemId()))
				.filter(t -> !StringUtils.isEmpty(t.getCategory().getCateId()))
				.isPresent();
	}
}
