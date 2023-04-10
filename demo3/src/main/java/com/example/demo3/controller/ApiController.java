package com.example.demo3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.UserDTO;

// IoC <-- 스프링 컨테이너에 싱글톤 패턴으로 올라간다 --> BEAN 객체
@RestController
@RequestMapping("/api")
public class ApiController {

	// 80 포트 번호는 주소창에서 생략 가능
	// http://localhost:80/api/hello
	// http://localhost/api/hello
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	// MIME TYPE : text/plain으로 응답 처리 해주세요
	// http://localhost/api/text
	// 응답 결과 -> 응답 : text/plain
	// http://localhost/api/text
	@GetMapping("/text")
	public String getText() {
		return "응답 : text/plain";
	}

	// dto로 받으면 자동으로 json 형식
	// response를 json 형식으로 내려주기
	// http://localhost/api/json
	@PostMapping("/json")
	public UserDTO json(@RequestBody UserDTO dto) {
		System.out.println(dto.toString());
		// 응답 Object type
		return dto;
	}

	// put : 수정
	// /api/put
	@PutMapping("/put")
	public ResponseEntity<UserDTO> put(@RequestBody UserDTO dto) {
		System.out.println(dto.toString());

		// HTTP 메세지 코드 200 직접 세팅
		// HTTP 메세지 body 데이터를 --> user object
//		return ResponseEntity.status(HttpStatus.OK).body(dto); // 200
		return ResponseEntity.status(HttpStatus.CREATED).body(dto); // 201
	}
	
	/*
	 * 백엔드 개발자 위치
	 * 클라이언터 (모바일) --> 요청(http 통신)
	 * 데이터로 반환 처리 (json 형식)
	 * 매번 새로운 요청마자 다른 형식으로 리턴을 해주면 api 계속 개발
	 * 일괄적인 형식을 만들어서 던져주면 api 개발자 좋아한다.
	 * 그래서 ResponseEntity에 일괄적인 형식을 만들어서 던져줌.
	 * 
	 *  자바스크립트 ajax 통신 처리
	 * */
	
	@PutMapping("/put2")
	public ResponseEntity<String> put2(@RequestBody UserDTO user){
		// 정상적인 값이 들어왔는지 확인, 인증된 사용자인지 확인
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		// 201 생성, 수정
		// (body, headers, status)
		return new ResponseEntity<>(user.toString(), headers, HttpStatus.CREATED);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> post2(@RequestBody UserDTO dto){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		return new ResponseEntity<>(dto.toString(), headers, HttpStatus.CREATED);
	}
	
}
