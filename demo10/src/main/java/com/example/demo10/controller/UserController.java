package com.example.demo10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo10.dto.UserDTO;

// IoC란 Spring Container에 객체를 올리기 위해
@Controller
public class UserController {

	// 1. 로그인 페이지를 직접 URL을 요청해서 응답받을 수 있다. (사전 지식)
	// 2. 로그인 페이지를 controller를 타서 응답처리 해보자.
	@GetMapping("/login-page") // URI 방식
	public String login() {
		return "login.html";
	}

	
	// 인증된 사용자만
	// 매개변수에 HttpServletRequest, HttpServletResponse
	// MIME TYPE - form태그 / @RequestBody는 application/json 
	@PostMapping("/login-proc")
	public String loginProc(HttpServletRequest request
			, HttpServletResponse response, UserDTO user) {
		//로직 : 세션 저장 후 myinfo 페이지 이동 처리함
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		System.out.println("user : " + user);

		// redirect: <-- 리다이렉트 됨.
		return "redirect:/mypage/myinfo.html";
	}
	
	// 인증된 사용자만 되도록 구현 못함 
	@PostMapping("/cart-proc")
	public String myinfoProc(HttpServletRequest request
			, HttpServletResponse response, UserDTO user) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		System.out.println("user : " + user);
		
		return "redirect:/mypage/cart.html";
	}
	
	// http://localhost:8080/mypage/myinfo <-- 설계해야 인터페이스 동작됨.
	// myinfo 주소 설계
	@GetMapping("/mypage/myinfo")
	public String myinfo() {
		// 폴더명도 같이 써줘야 함
		// 인증이 필요한 페이지로 만들기로 함.
		return "mypage/myinfo.html";
	}
	
	@GetMapping("/mypage/cart")
	public String cart() {
		return "mypage/cart.html";
	}
	
}
