package com.example.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

	private static Map<String, String>productRepo = new HashMap<>(); static {
		Product prd = new Product();
		prd.setId("1");
		prd.setName("Mohan");
		productRepo.put(prd.getId(), prd.getName());
		Product prdd = new Product();
		prdd.setId("2");
		prdd.setName("Sai");
		productRepo.put(prdd.getId(), prdd.getName());

	}
	
	  @RequestMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }
	
	
}
