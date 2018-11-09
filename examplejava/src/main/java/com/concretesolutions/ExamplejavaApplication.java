package com.concretesolutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamplejavaApplication {
    private static final Logger logger = LoggerFactory.getLogger(ExamplejavaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExamplejavaApplication.class, args);
        logger.info("LLEGUE");
	}
}
