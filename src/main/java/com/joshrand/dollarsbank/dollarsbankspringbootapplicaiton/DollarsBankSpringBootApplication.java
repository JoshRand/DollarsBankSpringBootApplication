package com.joshrand.dollarsbank.dollarsbankspringbootapplicaiton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.joshrand.dollarsbank.model")
@ComponentScan(basePackages="com")
@EnableJpaRepositories(basePackages = "com.joshrand.dollarsbank.repo")
public class DollarsBankSpringBootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DollarsBankSpringBootApplication.class, args);
	}

}
