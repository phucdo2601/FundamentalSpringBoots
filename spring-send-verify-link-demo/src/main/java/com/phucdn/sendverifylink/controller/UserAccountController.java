package com.phucdn.sendverifylink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.sendverifylink.domain.ConfirmationTokenEntity;
import com.phucdn.sendverifylink.domain.UserEntity;
import com.phucdn.sendverifylink.repository.ConfirmationTokenEntityRepository;
import com.phucdn.sendverifylink.repository.UserRepository;
import com.phucdn.sendverifylink.service.EmailService;

@Controller
public class UserAccountController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConfirmationTokenEntityRepository confirmationTokenEntityRepository;
	
	@Autowired
    private EmailService emailService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView displayRegistration(ModelAndView modelAndView,
			UserEntity userEntity) {
		modelAndView.addObject("userEntity", userEntity);
		modelAndView.setViewName("register");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView modelAndView,
			UserEntity userEntity) {
		UserEntity existingUser = userRepository.findByEmailIdIgnoreCase(userEntity.getEmailId());
		if (existingUser != null) {
			 modelAndView.addObject("message","This email already exists!");
			 modelAndView.setViewName("error");
		}
		else {
			userRepository.save(userEntity);

            ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(userEntity);

            confirmationTokenEntityRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userEntity.getEmailId());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailId", userEntity.getEmailId());

            modelAndView.setViewName("successfulRegisteration");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, 
			@RequestParam("token") String confirmationToken) {
		ConfirmationTokenEntity tokenEntity = confirmationTokenEntityRepository.findByConfirmationToken(confirmationToken);
		if (tokenEntity != null) {
			UserEntity user = userRepository.findByEmailIdIgnoreCase(tokenEntity.getUserEntity().getEmailId());
			user.setEnabled(true);
			userRepository.save(user);
			modelAndView.setViewName("accountVerified");
		}else {
			modelAndView.addObject("message","The link is invalid or broken!");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}
}
