package com.example.demo2.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.PostRequestDto;
import com.example.demo2.model.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {

	// METHOD : PUT
	// http://localhost:8080/api/put1
	// PUT은 body가 있음. @RequestBody
	@PutMapping("/put1")
	public PutRequestDto put(@RequestBody PutRequestDto req) {
		System.out.println("req : " + req);
		return req;
	}

	//http://localhost:8080/api/put2
	@PutMapping("/put2")
	public PutRequestDto put2(@RequestBody PutRequestDto reqDto) {
		System.out.println("reqDto : " + reqDto);
		return reqDto;
	}
}
