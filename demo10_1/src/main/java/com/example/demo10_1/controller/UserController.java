package com.example.demo10_1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@GetMapping("/loginPage")
	public String loginPage() {
		return "/login.html"; // 내부에서 이동
	}

	// 인증된 사용자만 들어올 수 있게 막을 예정
	// AuthInterceptor 동작 시키려면 주소 설계를 /auth/**로 만들어야 함
	@PostMapping("/login-proc")
	public String infoPage(HttpServletRequest request, @RequestParam String principal) {
		// 테스트
		// todo
		// 1. 아래 부분 삭제 예정
		// 2. 인터셉터가 동작하도록 주소 변경 예정
//		HttpSession session = request.getSession();
//		Object principal = session.getAttribute("principal");
//		if(principal == null) {
//			return "redirect:/loginPage";
//		}
		
		HttpSession session = request.getSession();
		System.out.println(principal);
		session.setAttribute("principal", principal);

		System.out.println("여기 코드 실행하려면 로그인 되야 함.");
		// 상대위치로 들어왔으면 현재 그 시점에서 맞게 설계
		// 위치에서 상대 경로 찾을지 절대 경로 찾을지 결정
		
		// URL (info.html) - http://localhost:8080/info.html
		// URI - http://localhost:8080/auth/infoPage
		
		// redirect <-- 어디까지 갔다오냐면 (브라우저로 돌아갔다 옴.)
		// 새로운 request와 response 객체가 만들어진다. 
		// http://localhost:8080/auth/infoPage
		return "redirect:/auth/infoPage";
	}
	
	@GetMapping("/auth/infoPage")
	public String info() {
		return "/info.html";
	}
}
