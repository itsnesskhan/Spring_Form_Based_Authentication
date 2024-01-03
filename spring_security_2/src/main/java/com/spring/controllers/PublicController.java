package com.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class PublicController {

	@GetMapping("/user")
	String greeting() {
		return "Welcome";
	}
	
	@GetMapping("/accessDenied")
	String error() {
		System.out.println("error occured!");
		return "access-denied";
	}
}
