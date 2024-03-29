package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostReqDto {

	private String name;
	private String email;
	private int age;
	private int hobby;
	// 코드 컨벤션이 깨지지 않도록 방지
	@JsonProperty("phone_number")
	private int phoneNumber;

}
