package com.videogamescollections.lp.service;

import java.util.List;
import java.util.Optional;

import com.videogamescollections.lp.model.Videogame;

public interface InterfacciaVideogameService {

	public Iterable<Videogame> getAll();

	public Optional<Videogame> getById(int id);

	public Videogame create(Videogame videogame);

	public Optional<Videogame> update(int id, Videogame videogame);

	public Boolean delete(int id);

	public List<Videogame> findByTitoloContaining(String titolo);

	public List<Videogame> searchVideogamesBySeries(String query);
	
	
	//public List<Videogame> searchAllGameInUserCollection(int userid, String titolo);
	public List<Videogame> searchAllGameInUserCollection(String query);
	
	public List<Videogame>getLastVideogameAdded(int limit);

	public List<Videogame> getVideogamesBySerie(int id);

}
