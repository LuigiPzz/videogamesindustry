package com.videogamescollections.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

	@RequestMapping("/index2")
	public String index2() {
		
		return "index2";
	}
	
	@RequestMapping("/searchPage")
	public String searchPage() {
		
		return "searchPage";
	}
	
	@RequestMapping("/videogame-detail")
	public String videogamedetail() {
		
		return "videogame-detail";
	}

}

