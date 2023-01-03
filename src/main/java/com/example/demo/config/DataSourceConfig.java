package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * File cau hinh connect data with server in spring boot de spring khong bao loi
 * @author phucdo
 *
 */
@Configuration
public class DataSourceConfig {
	
	@Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
          .driverClassName("com.mysql.cj.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/learn_spring_api_b01")
          .username("root")
          .password("12345678")
          .build();	
    }
}

