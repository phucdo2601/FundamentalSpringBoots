package com.phucdn.shoppingPage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phucdn.shoppingPage.entity.UserEntity;
import com.phucdn.shoppingPage.repository.RoleUserRepository;
import com.phucdn.shoppingPage.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleUserRepository roleUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = this.userRepository.findUserAccount(username);
		if (userEntity == null) {
			System.out.println("User not found! " + userEntity);
			throw new UsernameNotFoundException("User " + userEntity + " was not found in the database");
		}
		System.out.println("User Login: "+userEntity.getUserId());
		System.out.println("Pass Login: "+userEntity.getPassword());
//		System.out.println("Found User: " + userEntity);
		
		// [ROLE_USER, ROLE_ADMIN,..]
		
		List<String> roleNames = this.roleUserRepository.getRoleNames(userEntity.getUserId());
		System.out.println("Role name of user login: "+roleNames);
		List<GrantedAuthority> grantList = new ArrayList<>();
		if (roleNames != null) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		
		UserDetails userDetails = (UserDetails) new User(userEntity.getUserId(), 
				userEntity.getPassword(), grantList);
		
		return userDetails;
	}

	
}
