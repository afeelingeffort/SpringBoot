package com.example.demo10_1.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	// DI 적용
	@Autowired
	private AuthInterceptor authInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 규칙
		// 인증된 사용자만 들어오도록 auth
		// 주소 요청이 /auth/** 이 붙으면 AuthInterceptor 동작
		// 하도록 구현 처리
		registry.addInterceptor(authInterceptor).addPathPatterns("/auth/**");
	}
}
