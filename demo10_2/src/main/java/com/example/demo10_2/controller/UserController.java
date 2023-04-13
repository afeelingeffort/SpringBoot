package com.example.demo10_2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo10_2.dto.UserDTO;

@Controller
public class UserController {
	
	@GetMapping({"/", "login"})
	public String login() {
		return "/login";
	}
	
	@PostMapping("/login-proc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, UserDTO user) {
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		System.out.println(user);
		
		return "redirect:/auth/info";
	}
	
	// redirect로 넘어온 건 여기로 들어오도록 설계
	@GetMapping("/auth/info")
	public String info() {
		return "info";
	}
}
	
