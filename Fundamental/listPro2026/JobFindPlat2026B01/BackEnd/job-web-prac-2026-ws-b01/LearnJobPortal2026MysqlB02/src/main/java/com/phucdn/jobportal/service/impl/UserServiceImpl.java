package com.phucdn.jobportal.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phucdn.jobportal.dto.LoginDTO;
import com.phucdn.jobportal.dto.UserDTO;
import com.phucdn.jobportal.entity.OTP;
import com.phucdn.jobportal.entity.User;
import com.phucdn.jobportal.exception.JobPortalException;
import com.phucdn.jobportal.repository.OTPRepository;
import com.phucdn.jobportal.repository.UserRepository;
import com.phucdn.jobportal.service.UserService;
import com.phucdn.jobportal.utility.Data;
import com.phucdn.jobportal.utility.Utilities;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OTPRepository otpRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public UserDTO registerUser(UserDTO userDTO) throws JobPortalException {
		Optional<User> userExisted = userRepository.findByEmail(userDTO.getEmail());
		if (userExisted.isPresent()) {
			throw new JobPortalException("USER FOUND");
		}
		
		User user = userDTO.toEntity();
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user = userRepository.save(user);
		return user.toDto();
	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException {
		User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));
		
		if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
			throw new JobPortalException("INVALID_CREDENTIALS");
		}
		
		return user.toDto();
	}

	@Override
	public Boolean sendOtp(String email) throws Exception{
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email).orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));
		
		MimeMessage mm = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mm, true);
		
		messageHelper.setTo(email);	
		messageHelper.setSubject("Your OTP code");
		String genOtpString = Utilities.generateOTP();
		OTP otp = new OTP(email, genOtpString, LocalDateTime.now());
		otpRepository.save(otp);
		messageHelper.setText(Data.getMessageBody(genOtpString, user.getName()) , true);
		mailSender.send(mm);
		
		return true;
	}

	@Override
	public Boolean verifyOtp(String emai, String otp) throws JobPortalException {
		// TODO Auto-generated method stub
		OTP otpEntity = otpRepository.findById(emai).orElseThrow(() -> new JobPortalException("OTP_NOT_FOUND"));
		
		if (!otpEntity.getOtpCodeString().equals(otp)) {
			throw new JobPortalException("OTP_INCORRECT");
		}
		
		return true;
	}

}
