package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.PaymentClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
public class CartController {

	//@Autowired
	PaymentClient paymentClient;

	@Value("${student.name}")
	private String name;
	
	@Value("${welcome.message}")
	private String message;
	
	@Value("${env}")
	private String env;
	
	
	
	@GetMapping("/cart")
	public String getCart() {
		return "Hello World";
	}

	@GetMapping("/caart")
	@HystrixCommand(fallbackMethod = "getFallBack")
	public String getCa() {
		
		System.out.println(name);
		String payment = paymentClient.getPayment();
		System.out.println(payment);

		return payment;
	}
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}

	@GetMapping("/env")
	public String getEnv() {
		return env;
	}

	
	public String getFallBack() {
		return "PAYMENT Service is Down wait for sometime";
	}
	
}
