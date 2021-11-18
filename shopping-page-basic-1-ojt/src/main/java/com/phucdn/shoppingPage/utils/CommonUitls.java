package com.phucdn.shoppingPage.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.phucdn.shoppingPage.entity.UserEntity;

public class CommonUitls {
	
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return StringUtils.isEmpty(object);
		}
		
		return ObjectUtils.isEmpty(object);
	}
	
	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}

	// Dang sai can sua lai
	@Deprecated
	public static UserEntity getCurrentLoginUser() {
		UserEntity user = null;
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (CommonUitls.isNotEmpty(securityContext) && CommonUitls.isNotEmpty(securityContext.getAuthentication())) {
			Authentication authentication = securityContext.getAuthentication();
			if (CommonUitls.isNotEmpty(authentication.getDetails()) && authentication.getDetails() instanceof UserEntity) {
				user = (UserEntity) authentication.getDetails();
			}
		}
		return user;
	}
}
