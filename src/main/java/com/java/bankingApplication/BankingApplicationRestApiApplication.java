package com.java.bankingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.java.bankingApplication"})
public class BankingApplicationRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplicationRestApiApplication.class, args);
	}

}
