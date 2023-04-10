package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PostReqDto;

@RestController
@RequestMapping("/api2")
public class PostApiController {

	// 클라이언트에서 어떤 값을 보낼지 이미 알고 있다. id, pw같은 거
	// METHOD : POST
	// 시작줄 : http://localhost:8080/api2/post1/reqData
	// 클라이언트에서는 json 형식으로 보낼 예정
	@PostMapping("/post1")
	public void post1(@RequestBody Map<String, Object> reqData) {
		reqData.entrySet().forEach(e -> {
			System.out.println("key : " + e.getKey());
			System.out.println("value : " + e.getValue());
		});
	}

	// DTO 방식으로 처리 + JSON 형식으로 응답 처리
	// http://localhost:8080/api2/post2

	// 반환타입을 Dto로 받으면 JSON 형식으로 출력됨
	@PostMapping("/post2")
	public PostReqDto post2(@RequestBody PostReqDto reqDto) {
		return reqDto;
	}

//	// 강사님 localhost로 했던 메세지 실습
//	// GET : 주소 : path
//	@GetMapping("/chat/{message}")
//	public String message(@PathVariable String message) {
//		System.out.println("message : " + message);
//		return message;
//	}
}
