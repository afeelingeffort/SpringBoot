package com.example.demo9.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 인터셉터 만들기 
 * 1. HandlerInterceptor
 * 2. 3가지 메서드 기억
 * */
// @Autowired를 사용하기 위해 
// 어노테이션을 사용하지 않으면 주소값을 모르기에 올라가지 않음.
@Component // 1개의 BEAN
public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("------------------");
		System.out.println("Request URI : " + request.getRequestURI());
		System.out.println("Request Method : " + request.getMethod());

		// controller 안 타고 preHandle가 가로챔
		// return false;
		
		return true; // controller 탐
	}

	// View가 랜더링 되기 전에 동작
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
