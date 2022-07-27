package com.videogamescollections.lp.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.videogamescollections.lp.model.Videogame;
import com.videogamescollections.lp.service.InterfacciaVideogameService;


@RestController
public class AdminVideogameController {
	@Autowired
	@Qualifier("mainVideogameService")
	private InterfacciaVideogameService videogameService;
	
	@PostMapping(value = "/admin/api/newVideogame")
	public Videogame create(@Valid @RequestBody Videogame videogame) {

		return videogameService.create(videogame);
	}

}
