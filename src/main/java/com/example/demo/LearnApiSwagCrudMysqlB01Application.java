package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Phai @EnableWebMvc thi se khong con bi bao loi null thu vien (trong truong hop su dung 2 thu vien nay va cau hinh theo cach nay) 
 * - ko can chuyen doi version spring boot starter
 * @author phucdo
 *
 */

@SpringBootApplication
@EnableWebMvc
public class LearnApiSwagCrudMysqlB01Application {

	public static void main(String[] args) {
		SpringApplication.run(LearnApiSwagCrudMysqlB01Application.class, args);
	}

}
