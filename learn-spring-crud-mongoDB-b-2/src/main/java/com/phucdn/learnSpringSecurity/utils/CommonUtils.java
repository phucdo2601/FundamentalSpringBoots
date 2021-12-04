package com.phucdn.learnSpringSecurity.utils;

public class CommonUtils {
	public static String autoCreatePassword() {
		PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
					.useNumDigits(true).useLower(true).useUpper(true).usePunctuation(true).useFunc();
		
		return passwordGenerator.createPass(Constant.DEFAULT_PASSWORD_LENGTH);
	}
}
