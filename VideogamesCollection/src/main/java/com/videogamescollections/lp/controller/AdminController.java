package com.videogamescollections.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin", 
			method=RequestMethod.GET)
	public String index() {
		
		return "admin";
	}
	
	@RequestMapping(value = "/login", 
			method=RequestMethod.POST)
	public String login() {
		
		return "login";
	}
	
}
