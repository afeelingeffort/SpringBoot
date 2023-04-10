package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.UserDTO;

@RestController // IoC 관리 대상이 된다. (Spring Container에 싱글톤 패턴으로 들어간다.) -> BEAN 객체
@RequestMapping("/api")
public class RestApiController {
	
	// http://localhost:8080/api/get/100
	@GetMapping("/get/{id}")
	public void get(@PathVariable long id) {
		System.out.println("method : get");
		System.out.println("method : id " + id);
	}
	
	// http://localhost:8080/api/post
	@PostMapping("/post")
	public ResponseEntity<UserDTO> post(@RequestBody UserDTO user) {
		System.out.println("method : post");
		System.out.println("method : user " + user.toString());
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}
