package com.web.phucdn.services;

import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface IJwtService {
	public String extractUserNname(String token);

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	public String generateToken(UserDetails userDetails);

	public boolean isTokenValid(String token, UserDetails userDetails);

}
