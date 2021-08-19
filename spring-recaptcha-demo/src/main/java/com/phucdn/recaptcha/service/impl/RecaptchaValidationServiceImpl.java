package com.phucdn.recaptcha.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.phucdn.recaptcha.model.ReCaptchResponseType;
import com.phucdn.recaptcha.service.RecaptchaValidationService;

@Service
public class RecaptchaValidationServiceImpl implements RecaptchaValidationService{
	private static final String GOOGLE_RECAPTCHA_ENDPONIT = 
			"https://www.google.com/recaptcha/api/siteverify";
	
	private final String RECAPTCHA_SERCRET = 
			"6LdLGLAaAAAAAGwZS33Z4agBJf5WDxYlzMkW6HA_";
	
	@Override
	public boolean validateCaptcha(String captchaResponse) {
		RestTemplate restTemplate = new RestTemplate();
		
		MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
		
		requestMap.add("secret", RECAPTCHA_SERCRET);
		requestMap.add("response", captchaResponse);
		
		ReCaptchResponseType apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPONIT, requestMap, ReCaptchResponseType.class);
        if(apiResponse == null){
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.isSuccess());
	}
}
