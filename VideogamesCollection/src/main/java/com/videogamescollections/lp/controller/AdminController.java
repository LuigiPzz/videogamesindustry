package com.videogamescollections.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

	@GetMapping(value = "/admin")
	public String index() {
		
		return "admin";
	}
	
	@PostMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	
}
