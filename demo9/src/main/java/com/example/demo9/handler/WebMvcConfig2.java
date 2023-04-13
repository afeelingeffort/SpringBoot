package com.example.demo9.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 1개 이상의 빈
public class WebMvcConfig2 implements WebMvcConfigurer{
	
	@Autowired
	private LoggingInterceptor2 loggingInterceptor2;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor2);
	}
}
