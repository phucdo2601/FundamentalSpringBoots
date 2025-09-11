package com.web.phucdn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyProductStoreApiApplication {

	private static Logger logger = LoggerFactory.getLogger(DailyProductStoreApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DailyProductStoreApiApplication.class, args);
		
		logger.debug("Debug log message");
        logger.info("Started web log message");
	}

}
