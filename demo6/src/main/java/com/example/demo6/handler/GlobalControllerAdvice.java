package com.example.demo6.handler;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo6.dto.CustomError;

@RestControllerAdvice // IoC 대상이 된다.
//@ControllerAdvice // 페이지 리턴 오류시 작동
public class GlobalControllerAdvice {

	// 모든 예외를 여기서 처리하고 싶다면
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> Exception(Exception e) {
		System.out.println("-----------");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("-----------");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
							
	// 특정 예외를 잡아서 다르게 응답 처리하고 싶다면
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		// 디버깅
		// Stream API 활용
		// 필드가 잘못 되었는지
		// 메세지
		// String 값으로 재정의해서 응답처리 해주세요.

		// StringBuilder 사용
		// 데이터 가공해서 적절하게 응답 만들기
		List<CustomError> errorList = new ArrayList<>();
//		StringBuilder sb = new StringBuilder();
			e.getAllErrors().forEach(error -> {
				String field = error.getCode();
				String message = error.getDefaultMessage();
				CustomError customError = new CustomError();
				customError.setField(field);
				customError.setMessage(message);
				errorList.add(customError);
		});

		System.out.println("MethodArgumentNotValidException 잘못된 값을 전달했어");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {
		System.out.println("HttpMessageNotReadableException 아직도 json 형식 모르니");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(value = BindException.class)
	public ResponseEntity<?> bindException(BindException e) {
		System.out.println("BindException : GET 방식으로 값을 던질 때 잘못 보냈어");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
