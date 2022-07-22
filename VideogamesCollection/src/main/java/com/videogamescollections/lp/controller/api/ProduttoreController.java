package com.videogamescollections.lp.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videogamescollections.lp.model.Produttore;
import com.videogamescollections.lp.service.InterfacciaProduttoreService;

@CrossOrigin
@RestController
public class ProduttoreController {
	
	@Autowired
	@Qualifier("mainProduttoreService")
	private InterfacciaProduttoreService produttoreService;
	
	public ProduttoreController() {
		
	}
	

	@GetMapping(value = "/api/produttore")
	public Iterable<Produttore> getAll(){
		return produttoreService.getAll();
	}
	
}
