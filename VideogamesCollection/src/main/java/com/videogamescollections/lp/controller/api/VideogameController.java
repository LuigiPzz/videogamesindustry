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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.videogamescollections.lp.model.Videogame;
import com.videogamescollections.lp.service.InterfacciaVideogameService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin //TODO
@RestController
@RequestMapping("/api/videogames")
public class VideogameController {
	
	@Autowired
	@Qualifier("mainVideogameService")
	private InterfacciaVideogameService videogameService;
	
	public VideogameController() {
		
	}
	
	@GetMapping()
	public Iterable<Videogame> getAll(){
		return videogameService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Restituisce il singolo oggetto Videogame",
			description = "Utilizzato in: • videogame-detail.component")
				
	public Videogame getById(@PathVariable ("id") int id) {
		Optional<Videogame> videogame = videogameService.getById(id);
		if (videogame.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "videogame not found");
		}
		return videogame.get();
	}
	
	@GetMapping(value = "/serie/{id}")
	@Operation(summary = "Restituisce la lista di oggetto Videogame relativi ad una serie",
			description = "Utilizzato in: • ")
	public List<Videogame> getVideogamesBySerie(@PathVariable int id) {
		List<Videogame> videogame = videogameService.getVideogamesBySerie(id);
		if (videogame.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non ci sono altri videogame per la serie");
		}
		return videogame;
	}
	
	
	
	
	
	
	
	
	
	


	
	
	@GetMapping(value = "/api/videogamesCollection")
	public ResponseEntity<List<Videogame>> getAllGameInUserCollection(
			@RequestParam(value="userid",required=false) int userid, 
			@RequestParam(value="titolo",required=false) String query){
		return ResponseEntity.ok(videogameService.searchAllGameInUserCollection(query));
	}
	

	
	@GetMapping(value = "/api/search")
	public ResponseEntity<List<Videogame>> searchVideogamesByTitle(@RequestParam(value="query",required=false) String query){
		return ResponseEntity.ok(videogameService.searchVideogamesByTitle(query));
	}
	
	@GetMapping(value = "/api/searchSeries")
	public ResponseEntity<List<Videogame>> searchVideogamesBySeries(@RequestParam("query") String query){
		return ResponseEntity.ok(videogameService.searchVideogamesBySeries(query));
	}
	
	@GetMapping(value = "/api/lastVideogamesAdded")
	public Iterable<Videogame> getLastVideogameAdded(@RequestParam("limit") int limit){
		return videogameService.getLastVideogameAdded(limit);
	}
}
