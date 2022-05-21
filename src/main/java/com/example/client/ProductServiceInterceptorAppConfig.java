package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	ProductServiceInterceptor productServiceInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(productServiceInterceptor);
		
	}

}
