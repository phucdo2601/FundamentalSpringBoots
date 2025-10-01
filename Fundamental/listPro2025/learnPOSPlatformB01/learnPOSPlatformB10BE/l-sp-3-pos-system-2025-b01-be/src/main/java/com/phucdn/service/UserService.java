package com.phucdn.service;

import java.util.List;

import com.phucdn.exceptions.UserException;
import com.phucdn.model.User;

public interface UserService {
	User getUserFromJwtToken(String token) throws UserException;
	User getCurrentUser() throws UserException;
	User getUserByEmail(String email) throws UserException;
	User getUserById(Long id) throws UserException, Exception;
	List<User> getAllUsers();
}
