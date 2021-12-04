package com.phucdn.learnSpringSecurity.service;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.dto.authorization.PermissionChecker;
import com.phucdn.learnSpringSecurity.exception.UserAccessFailedException;
import com.phucdn.learnSpringSecurity.utils.Messages;

@Service
public class AuthorizeService {

	private String userId;
	
	public boolean checkStatus(Function<PermissionChecker, Integer> conditions) {
		
		return true;
	}
	
	public void asserts(Function<PermissionChecker, Integer> conditions) {
		if (!checkStatus(conditions)) {
			throw new UserAccessFailedException(Messages.USER_NOT_PERMISSION);
		}
	}
}
