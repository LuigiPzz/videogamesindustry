package com.videogamescollections.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		
		return "index";
	}

	@GetMapping("/index2")
	public String index2() {
		
		return "index2";
	}
	
	@GetMapping("/searchPage")
	public String searchPage() {
		
		return "searchPage";
	}
	
	@GetMapping("/videogame-detail")
	public String videogamedetail() {
		
		return "videogame-detail";
	}

}

