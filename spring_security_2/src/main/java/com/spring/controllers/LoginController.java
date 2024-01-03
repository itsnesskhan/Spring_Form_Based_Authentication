package com.spring.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class LoginController {
	
	@GetMapping("/signin")
	public String showLoginForm() {
		return "login-form";
	}
	
	@GetMapping("user/profile")
	public String showProfile(Principal principal, Model model) {
		model.addAttribute("user", principal.getName());
		return "profile";
	}
	
	public void logoutHandler() {
		
	}
	

	

}
