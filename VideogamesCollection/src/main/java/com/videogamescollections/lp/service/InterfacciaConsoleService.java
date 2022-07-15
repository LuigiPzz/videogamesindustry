package com.videogamescollections.lp.service;

import java.util.Optional;

import com.videogamescollections.lp.model.Console;

public interface InterfacciaConsoleService {
	
	public Iterable<Console> getAll();
	
	public Optional<Console> getById(int id);
	
	public Console create(Console console);
	
	public Optional<Console> update(int id, Console console);
	
	public Boolean delete(int id);

}
