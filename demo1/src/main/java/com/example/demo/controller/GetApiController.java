package com.example.demo.controller;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

// @Controller <- 화면 응답 (HTML(jsp))
@RestController // <- JSON 방식으로 응답 처리된다.
@RequestMapping("/api")
public class GetApiController {

	// 주소 - GET 방식 path Variable 방식
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}

	// 쿼리 파람 방식으로 데이터를 파싱해서 처리하자.
	// http://localhost:8080/api/queryParam1?name=홍아
	@GetMapping("/queryParam1")
	public String queryParam1(@RequestParam String name) {
		System.out.println("name : " + name);
		return "name : " + name;
	}

	// key = value 방식
	// @RequestParam은 기본값이 true이다.
	// 쿼리 스트링 방식으로 주소 설계를 했다면 요청시에 매개변수를 다 받아야 한다.
	// 아니면 오류 발생 (하지만 선택적 요소로 만들 수도 있다.)

	// @RequestParam(required = false, defaultValue = "0")
	// ()안에 required = false, defaultValue = "0"를 이용하여
	// 선택적 요소로 만들 수 있음.

	// http://localhost:8080/api/queryParam2?name=홍아&age=10
	// http://localhost:8080/api/queryParam2?name=홍아 -> error
	@GetMapping("/queryParam2")
	public String queryParam2(@RequestParam String name
			, @RequestParam(required = false, defaultValue = "0") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name, age : " + name;
	}
	
	
	// http://localhost:8080/api/queryParam3?name=홍아&age=10&groupId=com.tenco
	// 약속 지켜서 하나하나 매개변수를 넣지 않더라도 실행됨.

	// http://localhost:8080/api/queryParam3?name=홍아&age=10
	// Map 방식 -> { }
	@GetMapping("/queryParam3")
	public String queryParam3(@RequestParam Map<String, String> data) {

		StringBuilder sb = new StringBuilder();
		
		// stream + 반복문을 돌리기 위해서 entrySet()
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		System.out.println("data : " + data.toString());
		return "파싱 - map 방식의 이해 : " + sb.toString();
	}

	// Map 활용 메서드 (직접 만들어 보기)
	// http://localhost:8080/api/queryParam4?id=asdf&pw=1234
	@GetMapping("/queryParam4")
	public String queryParam4(@RequestParam Map<String, Integer> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(str -> {
			System.out.println(str.getKey());
			System.out.println(str.getValue());
			System.out.println();
			
			sb.append(str.getKey() + str.getValue());
		});
		
		System.out.println("data : " + data.toString());
		return "파싱 map : " + sb.toString();
	}
	
	// DTO 객체를 만들어서 처리
	// 주소 : GET 방식
	// http://localhost:8080/api/queryParam5?name=홍아&age=10&email=a@naver.com
	
	// Message Converter 동작해서 자동으로 파싱 처리
	// @RequestParam 붙이지 말아야 한다 !!!
	// dto의 속성값이 없으면 파싱을 하지 않는다.
	@GetMapping("/queryParam5")
	public String queryParam5(UserRequest userDto) {
		System.out.println("Dto 방식 동작 처리");
		
		System.out.println(userDto.getName());
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		
		return userDto.toString();
	}
	
	//pathVariable 방식의 사용
	// http://localhost:8080/api/path-variable/10
	@GetMapping("/path-variable/{userId}")
	public String pathVariable1(@PathVariable int userId) {
		System.out.println("userId : "+ userId);
		return "userId " + userId;
	}

	// pathVariable 방식
	// 변수명을 똑같이 사용하지 못할 때 옵션 값을 지정할 수 있다.
	// http://localhost:8080/api/path-variable2/홍아
	@GetMapping("/path-variable2/{name}")
	public String pathVariable2(@PathVariable(name = "name") String mName) {
		String name = "내부에 name 변수명이 있음.";
		return "name " + mName;
	}
	
	// GET 방식 
	// http://localhost:8080/api/users/3/orders/10
	@GetMapping("/users/{userId}/orders/{orderId}")
	public String getOrder(@PathVariable int userId,
			@PathVariable int orderId) {
		
		return "userId : " + userId + ", orderId : " + orderId;
	}
	
	// http://localhost:8080/api/name/흥아
	// DTO 매핑은 @PathVariable 선언없이 사용하기.
	// DTO 안에 매핑할 변수와 키 값이 같아야 한다. 
	@GetMapping("/name/{name}")
	public UserRequest getUser(UserRequest dto) {
		UserRequest userRequest = new UserRequest();
		userRequest.setName(dto.getName());
		
		// @RestController
		return userRequest; 
	}
	
}
