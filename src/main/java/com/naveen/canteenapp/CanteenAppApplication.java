package com.naveen.canteenapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CanteenAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanteenAppApplication.class, args);
	}

}
