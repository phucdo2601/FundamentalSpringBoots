package com.phucdn.sendverifylink.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {

	void sendEmail(SimpleMailMessage email);

}
