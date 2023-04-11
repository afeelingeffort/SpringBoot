package com.example.demo5.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

//	@NotNull(message ="넌 이름이 없니?")
	private String name;
//	@NotNull(message ="ㅁㄹㄴㅇ")
	@Min(10)
	private int age;
	@Email(message = "넌 이메일 형식도 모르니?")
	private String email;
//	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "010-0000-0000 형식으로 입력해야 합니다.")
	private String phoneNumber;
	
}
