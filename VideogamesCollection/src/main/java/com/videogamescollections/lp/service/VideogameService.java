package com.videogamescollections.lp.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Videogame;



@Service
public class VideogameService implements InterfacciaVideogameService {
	
	private List<Videogame> list;
	public VideogameService() {		
		list = new ArrayList<Videogame>();
	}

	@Override
	public Iterable<Videogame> getAll() {
		return list;
	}

	@Override
	public Optional<Videogame> getById(int id) {
		Optional<Videogame> videogame = list.stream().filter(item->item.getId() == id).findFirst();
		return videogame;
	}

	@Override
	public Videogame create(Videogame videogame) {
		list.add(videogame);
		return videogame;
	}

	@Override
	public Optional<Videogame> update(int id, Videogame videogame) {
		Optional<Videogame> foundVideogame = list.stream().filter(item->item.getId() == id).findFirst();	
		if (foundVideogame.isEmpty()) {	
			return Optional.empty();
		}	
		foundVideogame.get().setTitolo(videogame.getTitolo());	
		foundVideogame.get().setPosseduto(videogame.getPosseduto());
		foundVideogame.get().setConsole(videogame.console);
		foundVideogame.get().setSerie(videogame.getSerie());
		return foundVideogame;
	}

	@Override
	public Boolean delete(int id) {
		Optional<Videogame> foundVideogame = list.stream().filter(item->item.getId() == id).findFirst();
		if (foundVideogame.isEmpty()) {
			return false;
		}
		list.remove(foundVideogame.get());
		return true;
	}


	@Override
	public List<Videogame> searchVideogamesByTitle(String query) {
		return Collections.emptyList();
	}

	@Override
	public List<Videogame> searchVideogamesBySeries(String query) {
		return Collections.emptyList();
	}

	@Override
	public List<Videogame> searchAllGameInUserCollection(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> getLastVideogameAdded(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
