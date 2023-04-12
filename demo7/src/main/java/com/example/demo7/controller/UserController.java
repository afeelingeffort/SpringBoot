package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 화면에 띄우기
@Controller // IoC 처리됨. 
public class UserController {

	//http://localhost:8080/
	//http://localhost:8080/user
	@GetMapping({"/", "user"})
	public String userPage(Model model) {
		// application.yml 파일에 아래와 같이 선언해놔서 
		// prefix : /WEB-INF/view/
		// suffix : .jsp
		
		// 중간에 파일 이름만 적어주면 됨.
		// /WEB-INF/view/' '.jsp <--가 완성 됨.
		// viewResolver가 동작해서 페이를 찾고 리턴
		
		// 데이터를 내려 보내고 싶다면
		model.addAttribute("principal", "ㅎㅇ");
		return "user";
	}
	
}
