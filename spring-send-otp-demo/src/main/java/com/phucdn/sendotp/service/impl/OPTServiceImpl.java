package com.phucdn.sendotp.service.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.phucdn.sendotp.service.OTPService;

@Service
public class OPTServiceImpl implements OTPService {
	private static final Integer EXPIRE_MINS = 4;
	private LoadingCache<String, Integer> otpCache;

	public OPTServiceImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}
	
	@Override
	public int generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}
	
	@Override
	public int getOTP(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}

}
