package com.phucdn.recaptcha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReCaptchResponseType {
	private boolean success;
	private String challenge_ts;
	private String hostname;
	
}
