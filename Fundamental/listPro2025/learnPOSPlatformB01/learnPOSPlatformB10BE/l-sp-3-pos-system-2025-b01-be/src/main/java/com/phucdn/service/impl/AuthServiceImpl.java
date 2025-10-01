package com.phucdn.service.impl;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phucdn.configuration.JwtProvider;
import com.phucdn.domain.UserRole;
import com.phucdn.exceptions.UserException;
import com.phucdn.mapper.UserMapper;
import com.phucdn.model.User;
import com.phucdn.payload.dto.UserDto;
import com.phucdn.payload.response.AuthResponse;
import com.phucdn.repository.UserRepository;
import com.phucdn.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtProvider jwtProvider;
	private final CustomUserImplementation customUserImplementation;

	@Override
	public AuthResponse signUp(UserDto userDto) throws UserException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(userDto.getEmail());
		if (user != null) {
			throw new UserException("Email is already registered!");
		}
		if (userDto.getRole().equals(UserRole.ROLE_ADMIN)) {
			throw new UserException("Role admin is not allowed!");
		}
		
		User newUser = new User();
		newUser.setEmail(userDto.getEmail());
		newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
		newUser.setRole(userDto.getRole());
		newUser.setFullName(userDto.getFullName());
		newUser.setPhone(userDto.getPhone());
		newUser.setCreatedDate(LocalDateTime.now());
		newUser.setUpdatedDate(LocalDateTime.now());
		
		User savedUser = userRepository.save(newUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToken(authentication);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("Registered sucessfully!");
		authResponse.setUser(UserMapper.toDto(savedUser));
		
		return authResponse;
	}

	@Override
	public AuthResponse login(UserDto userDto) throws UserException {
		// TODO Auto-generated method stub
		String email = userDto.getEmail();
		String password = userDto.getPassword();
		Authentication authentication = authentication(email, password);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		String role = authorities.iterator().next().getAuthority();
		
		String jwt = jwtProvider.generateToken(authentication);
		
		User user = userRepository.findByEmail(email);
		
		user.setLastLogin(LocalDateTime.now());
		userRepository.save(user);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("Login sucessfully!");
		authResponse.setUser(UserMapper.toDto(user));
		
		return authResponse;
	}
	
	private Authentication authentication(String email, String password) throws UserException {
		
		UserDetails userDetails = customUserImplementation.loadUserByUsername(email);
		
		if (userDetails == null) {
			throw new UserException("Email id does not exist "+ email);
		}
		
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new UserException("Password does not match");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

}
