
package com.example.demo5.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@Validated // !!!!!! GET 방식일 때 반드시 선언해주어야 유효성 검사를 시작함.
public class UserController {

	// GET 방식일 때 파라미터 앞에 어떤 유효성 검사를 할지
	// 당연히 지정해 주어야 한다.
	
	// @Valid라고 명시하면 dto에 있는 것들의 유효성 검사를 하고,
	// 매개변수에 유효성 검사를 명시하면 해당 매핑만 유효성 검사를 함.

	// http://localhost:8080/user?name=홍길동&age=12
	// GET 방식일 때 valid 처리
	@GetMapping("/user")
	public User user(@Size(min = 2) @RequestParam String name, @NotNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		return user;
	}

	// http://localhost:8080/user3?name=홍아
	// @Validated, @Valid 둘 다 됨.
	@GetMapping("/user3")
	// object mapper 통해서 파싱 처리하고 싶다면
	public User user2(@Valid User user) {
		return user;
	}

	// 이렇게 말고 위처럼 하면 되잖아 븅아
	// http://localhost:8080/user2/name/홍아/age/20
	// 문제 GET 유효성 검사 직접 만들어보기
	@GetMapping("/user2/name/{name}/age/{age}/email/{email}/phone/{phone}")
	public User user2(@NotNull @PathVariable String name, @Min(5) @PathVariable Integer age,
			@NotNull @PathVariable String email, @PathVariable String phone) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		user.setPhoneNumber(phone);
		return user;
	}

}
