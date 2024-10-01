package com.yash.banking.customer_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class CustomerWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebservicesApplication.class, args);
	}

}
