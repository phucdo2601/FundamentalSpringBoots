package com.phucdn.learnSpringSecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserAccessFailedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 454551043915447689L;

	public UserAccessFailedException(String mess) {
		// TODO Auto-generated constructor stub
		super(mess);
	}
}
