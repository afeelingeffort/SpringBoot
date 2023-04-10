package com.example.demo2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//API Tester 사용하기
@RestController
@RequestMapping("/api2")
public class DeleteApiController {

	// METHOD : DELETE
	// http://localhost:8080/api2/delete/userId/{userId}
	// http://localhost:8080/api2/delete/userId/{userId}?account=우리은행
	// http://localhost:8080/api2/delete/100?account=우리은행
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId,
			@RequestParam String account) {
		System.out.println("userId : " + userId);
		System.out.println("account : " + account);
	}
	
	// 문제 delete 주소 설계 및 응답 처리
	// path, query, path + query 둘 다 사용하기
	// http://localhost:8080/api2/delete2?name=길동/1234
	//http://localhost:8080/api2/delete2?name=길동&pw=1234
	@DeleteMapping("/delete2")
	public void delete2(@RequestParam String name,
			@RequestParam String pw) {
		System.out.println("name : " + name);
		System.out.println("pw : " + pw);
	}
	

}
