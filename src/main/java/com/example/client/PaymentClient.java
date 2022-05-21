package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "payment", url = "http://localhost:8082")
// @FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

//	@GetMapping("/payment")
	public String getPayment();

}
