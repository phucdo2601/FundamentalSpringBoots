package com.phucdn.sendotp.service;

import javax.mail.MessagingException;

public interface EmailService {

	void sendOtpMessage(String to, String subject, String message) throws MessagingException;

}
