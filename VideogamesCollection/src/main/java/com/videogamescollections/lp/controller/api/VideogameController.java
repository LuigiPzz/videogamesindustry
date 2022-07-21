package com.videogamescollections.lp.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.videogamescollections.lp.model.Videogame;
import com.videogamescollections.lp.service.InterfacciaVideogameService;

@RestController
public class VideogameController {
	
	@Autowired
	@Qualifier("mainVideogameService")
	private InterfacciaVideogameService videogameService;
	
	public VideogameController() {
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/api/videogames")
	public Iterable<Videogame> getAll(){
		return videogameService.getAll();
	}
	
	@GetMapping(value = "/api/videogames/{id}")
	public Videogame getById(@PathVariable int id) {
		Optional<Videogame> videogame = videogameService.getById(id);
		if (videogame.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "videogame not found");
		}
		return videogame.get();
	}
	
	@GetMapping(value = "/api/search")
	public ResponseEntity<List<Videogame>> searchVideogamesByTitle(@RequestParam("query") String query){
		return ResponseEntity.ok(videogameService.searchVideogamesByTitle(query));
	}
	
	@GetMapping(value = "/api/searchSeries")
	public ResponseEntity<List<Videogame>> searchVideogamesBySeries(@RequestParam("query") String query){
		return ResponseEntity.ok(videogameService.searchVideogamesBySeries(query));
	}
}
