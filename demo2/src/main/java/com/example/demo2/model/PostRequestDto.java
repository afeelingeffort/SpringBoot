package com.example.demo2.model;

import lombok.Data;
import lombok.ToString;

@Data // getter, setter 둘 다 만들어줌
@ToString
public class PostRequestDto {

	private String name;
	private String age;

}
