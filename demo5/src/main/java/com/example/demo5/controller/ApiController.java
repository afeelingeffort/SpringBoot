package com.example.demo5.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// method : post
	// http://localhost:8080/api/user
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		// 스프링 부트의 요청시 데이터 기본 파싱 전략은 key = value 구조
		// dto <-- object mapper 동작을 해서 자동 파싱해서 처리해준다.
		// 유효성 검사 - 예전 방식
		if (user.getAge() < 1 || user.getAge() > 100) {
			// 잘못된 입력값을 확인
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}

		// 빌더 패턴으로 값 넣기
		User user2 = User.builder().name("티모").age(0).email("ㅁsdf").phoneNumber("010-2141-1234").build();

		// 서비스 만들어서 (로직) --> DAO 던져서 (DB insert)
		// 정방향 갔다가 --> 역방향으로 돌아옴. --> 응답 처리
//		System.out.println(user);
		return ResponseEntity.ok(user2);
	}

	//http://localhost:8080/api/user2/
	// 두번째 연습
	// AOP 기반인 Validation 라이브러리 활용하기.
	// 1. GET 방식일 때 사용 방법과 POST 방식일 때 사용방법이 약간 다르다.
	// 반드시 @Valid 선언을 해주어야 한다.
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user) {
		// 관점 지향 패러다임 추가
		// AOP 기반에 valid 라이브러리를 활용하면 공통적으로 들어가야
		// 하는 부분의 코드를 분리시킬 수 있다.
		System.out.println(user);
		return ResponseEntity.ok(user);
	}

	// 와일드 카드 -> 제네릭 타입에 <?> 사용가능
	@PostMapping("/user3")
	public ResponseEntity<?> user3(@Valid @RequestBody User user
			, BindingResult bindingResult) {
		// bindingResult 클래스를 배워보자.
		// bindingResult 가 @Valid에 대한 결과값을 가지고 있다.
		if (bindingResult.hasErrors()) {
			
			StringBuilder sb = new StringBuilder();
			
			bindingResult.getAllErrors().forEach(error -> {
				error.getCode();
				error.getDefaultMessage();
			});
			// 여기는 에러 발생
			// 필드 - 어떤 필드에서 에러 발생 ? 
			// 메세지 - 내용을 반환 처리
			// 반환타입 .body("에러발생")의 String
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		// 정상 처리
		// 반환 타입 user
		return ResponseEntity.ok(user);
	}
}
