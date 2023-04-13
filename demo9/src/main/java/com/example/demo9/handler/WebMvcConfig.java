package com.example.demo9.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 1. WebMvcConfiturer 구현 처리하기
 * */
@Configuration // 1개 이상 빈으로 등록해야 할 때
public class WebMvcConfig implements WebMvcConfigurer {

	// DI를 사용하는 코드로 변경해보자.
	@Autowired // DI 적용
	private LoggingInterceptor loggingInterceptor;

//	public WebMvcConfig(LoggingInterceptor loggingInterceptor) {
//		this.loggingInterceptor = loggingInterceptor;
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 우리가 직접 만든 인터셉터 구현클래스를 등록 처리 합니다.
		registry.addInterceptor(loggingInterceptor);

	}

}
