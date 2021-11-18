package com.phucdn.shoppingPage.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class WebUtils {
	public static String toString(User user) {
		StringBuilder sb = new StringBuilder();

		sb.append("UserName:").append(user.getUsername());

		Collection<GrantedAuthority> authorities = user.getAuthorities();
		if (authorities != null && !authorities.isEmpty()) {
			sb.append(" (");
			boolean first = true;
			for (GrantedAuthority a : authorities) {
				if (first) {
					sb.append(a.getAuthority());
					first = false;
				} else {
					sb.append(", ").append(a.getAuthority());
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}

	public static String toString2(User user) {
		StringBuilder sb = new StringBuilder();

		Collection<GrantedAuthority> authorities = user.getAuthorities();
		for (GrantedAuthority a : authorities) {

			sb.append(a.getAuthority());

		}
		
		return sb.toString();
	}
}
