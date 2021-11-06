package com.phucdn.learnSpringSecurity.utils;

import java.util.Date;

public class DateInstance {
	public static Date getCurrentTime() {
		long mills = System.currentTimeMillis();
		Date currentTime = new Date(mills);
		return currentTime;
	}
}
