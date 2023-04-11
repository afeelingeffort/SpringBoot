package com.example.demo5.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@RequestMapping("/api2")
public class ApiController2 {

	@PostMapping("/user4")
	public ResponseEntity<?> user4(@Valid @RequestBody User user
			, BindingResult bindingResult){
		// bindingResult는 @Valid에 대한 결과값을 가지고 있음!!
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			
			bindingResult.getAllErrors().forEach(error ->{
				sb.append("field : " +error.getCode());
				sb.append("\n");
				sb.append("message : " +error.getDefaultMessage());
				sb.append("\n");
			});
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		
		return ResponseEntity.ok(user);
	}
	
}
