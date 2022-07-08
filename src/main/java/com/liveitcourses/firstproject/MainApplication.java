package com.liveitcourses.firstproject;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Log4j2
@ComponentScan(basePackages = {"com.liveitcourses.firstproject"})
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	/*@Bean
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			log.info("message from application.properties " + environment.getProperty("logging.level.org.springframework"));
		};
	}*/
}

