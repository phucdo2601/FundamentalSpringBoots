package com.phucdn.learnSpringSecurityLoginGmail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
			withUser("phucdo2601").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
		
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
			withUser("thaiNguyen2404").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Chi cho phep user co quyen ADMIN truy cap duong dan /admin/**
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		
		//Chi cho phep user co quyen ADMIN hoac USER truy cap duong dan /user/**
		http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')");
		
		//Khi nguoi dung da login voi vai tro la user, 
		//nhung truy cap vao trang yeu cau vai tro ADMIN, se chuyen huong toi trang 403
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		//Cau hinh Login Form
		http.authorizeRequests().and().formLogin()
			.loginProcessingUrl("/j_spring_security_login")
			.loginPage("/login")
			.defaultSuccessUrl("/user")
			.failureUrl("/login?message=error")
			.usernameParameter("username")
			.passwordParameter("password")
			
			//Cau hinh logout page
			.and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
	}
	
	
}
