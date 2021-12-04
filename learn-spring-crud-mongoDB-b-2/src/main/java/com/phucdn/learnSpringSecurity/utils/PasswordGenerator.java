package com.phucdn.learnSpringSecurity.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordGenerator {

	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUM_DIGITS = "1234567890";
	private static final String PUNCTUATION = "!@#$%^&*()_-+=,./<>?|`~[]{}";
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private boolean isUpper;
	private boolean isNumDigits;
	private boolean isPunctuation;
	private boolean isLower;
	
	public PasswordGenerator(PasswordGeneratorBuilder builder) {
		this.isLower = builder.isLower;
		this.isNumDigits = builder.isNumDigits;
		this.isPunctuation = builder.isPunctuation;
		this.isUpper = builder.isUpper;
	}
	
	public static class PasswordGeneratorBuilder{
		private boolean isUpper;
		private boolean isNumDigits;
		private boolean isPunctuation;
		private boolean isLower;
		
		public PasswordGeneratorBuilder() {
			this.isLower = false;
			this.isNumDigits = false;
			this.isPunctuation = false;
			this.isLower = false;
		}
		
		public PasswordGeneratorBuilder useLower(boolean isLower) {
			this.isLower = isLower;
			return this;
		}
		
		public PasswordGeneratorBuilder useNumDigits(boolean isNumDigits) {
			this.isNumDigits = isNumDigits;
			return this;
		}
		
		public PasswordGeneratorBuilder usePunctuation(boolean isPunctuation) {
			this.isPunctuation = isPunctuation;
			return this;
		}
		
		public PasswordGeneratorBuilder useUpper(boolean isUpper) {
			this.isUpper = isUpper;
			return this;
		}
		
		public PasswordGenerator useFunc() {
			return new PasswordGenerator(this);
		}
	}
	
	public String createPass(int length) {
		if (length < 0) {
			return "";
		}
		
		StringBuilder password = new StringBuilder(length);
		Random ran = new Random(System.nanoTime());
		
		List<String> charCategories = new ArrayList<>();
		if (isLower) {
			charCategories.add(LOWER);
		}
		if (isNumDigits) {
			charCategories.add(NUM_DIGITS);
		}
		if (isPunctuation) {
			charCategories.add(PUNCTUATION);
		}
		if (isUpper) {
			charCategories.add(UPPER);
		}
		
		for (int i = 0; i < length; i++) {
			String charCategory = charCategories.get(ran.nextInt(charCategories.size()));
			int position = ran.nextInt(charCategory.length());
			password.append(charCategory.charAt(position));
		}
		System.out.println(password);
		return new String(password);
	}
	
	
	
}
