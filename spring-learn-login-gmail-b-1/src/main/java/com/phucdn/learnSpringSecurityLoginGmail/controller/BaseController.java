package com.phucdn.learnSpringSecurityLoginGmail.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phucdn.learnSpringSecurityLoginGmail.dto.GooglePojo;
import com.phucdn.learnSpringSecurityLoginGmail.utils.GoogleUtils;

@Controller
public class BaseController {

	@Autowired
	private GoogleUtils googleUtils;

	@Autowired
	private HttpServletRequest request;

	// neu khong dat method tra ve thi mac dinh la GET
	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login-google", method = RequestMethod.GET)
	public String loginGoogle() throws ClientProtocolException, IOException {
		String code = request.getParameter("code");
		
		if (code == null || code.isEmpty()) {
			return "redirect:/login?google=error";
		}
		
		 String accessToken = googleUtils.getToken(code);
		    
		    GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
		    UserDetails userDetail = googleUtils.buildUser(googlePojo);
		    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
		        userDetail.getAuthorities());
		    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    SecurityContextHolder.getContext().setAuthentication(authentication);
		    return "redirect:/user";
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "403";
	}
}
