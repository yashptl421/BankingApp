package com.yash.banking.webervices.banking_web_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankingWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingWebServicesApplication.class, args);
	}

}
