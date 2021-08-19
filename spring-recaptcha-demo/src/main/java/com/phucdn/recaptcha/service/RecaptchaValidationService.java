package com.phucdn.recaptcha.service;

public interface RecaptchaValidationService {

	boolean validateCaptcha(String captchaResponse);

}
