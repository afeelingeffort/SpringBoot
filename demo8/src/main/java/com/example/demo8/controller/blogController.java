package com.example.demo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class blogController {

	// gradle 설정해주기 꼭 
	// http://localhost:8080/
	// http://localhost:8080/blog
	@GetMapping({"/", "blog"})
	public String blogPage() {
		return "greensBlog";
	}

	
}
