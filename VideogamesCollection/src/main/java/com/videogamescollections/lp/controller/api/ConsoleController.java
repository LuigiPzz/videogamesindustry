package com.videogamescollections.lp.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.videogamescollections.lp.model.Console;
import com.videogamescollections.lp.service.InterfacciaConsoleService;

@CrossOrigin
@RestController
public class ConsoleController {
	
	@Autowired
	@Qualifier("mainConsoleService")
	private InterfacciaConsoleService consoleService;
	
	public ConsoleController() {
		
	}
	
	@GetMapping("/api/consoles")
	public Iterable<Console> getAll(){
		return consoleService.getAll();
	}
	
	@GetMapping("/api/consoles/{id}")
	public Console getById(@PathVariable int id) {
		
		Optional<Console> console = consoleService.getById(id);
		
		if (console.isEmpty()) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "videogame not found");
		}
		return console.get();
	}

}
