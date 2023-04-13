
package com.example.demo9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

@RestController
public class PublicController2 implements HandlerInterceptor{

	@GetMapping("/hi")
	public String hi() {
		System.out.println("hi");
		return "hi";
	}
	
}
