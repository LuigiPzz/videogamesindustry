package com.videogamescollections.lp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Videogame;
import com.videogamescollections.lp.repository.IVideogameRepository;

import ch.qos.logback.classic.Logger;

@Service("mainVideogameService")
public class DbVideogameService implements InterfacciaVideogameService {
	
	private Logger log = null;

	@Autowired
	private IVideogameRepository videogameRepository;
	
	@Override
	public Iterable<Videogame> getAll() {
		return videogameRepository.findAll();
	}
	
	@Override
	public Optional<Videogame> getById(int id) {
		return videogameRepository.findById(id);
	}
	
	@Override
	public Videogame create(Videogame videogame) {
		
		return videogameRepository.save(videogame);
	}
	
	@Override
	public Optional<Videogame> update(int id, Videogame videogame) {
		
		Optional<Videogame> foundVideogame = videogameRepository.findById(id);
		
		if (foundVideogame.isEmpty()) {
			
			return Optional.empty();
		}
		
		foundVideogame.get().setTitolo(videogame.getTitolo());
		foundVideogame.get().setPosseduto(videogame.getPosseduto());
		foundVideogame.get().setConsole(videogame.console);
		foundVideogame.get().setSerie(videogame.getSerie());
		
		videogameRepository.save(foundVideogame.get());
		
		return foundVideogame;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Videogame> foundVideogame = videogameRepository.findById(id);
		
		if (foundVideogame.isEmpty()) {
			
			return false;
		}
		
		videogameRepository.delete(foundVideogame.get());
		
		return true;
	}

	@Override
	public List<Videogame> searchVideogamesByTitle(String query) {
		List<Videogame> videogamesSearchList= videogameRepository.searchVideogamesByTitle(query);
		return videogamesSearchList;
	}

	@Override
	public List<Videogame> searchVideogamesBySeries(String query) {
		List<Videogame> videogamesSearchList= videogameRepository.searchVideogamesBySeries(query);
		return videogamesSearchList;
	}
	
	public String retriveVideogamePath(Videogame videogame, String latoImmagine) {
		String produttore = (videogame.getConsole().getProduttore().getNome()).toLowerCase();
		String console = (videogame.getConsole().getNome()).toLowerCase();
		String vidoegameUrlPath = produttore + '-' + console +'-'+'['+videogame.getTitolo()+']'+latoImmagine+".jpeg";
		//System.out.print(vidoegameUrlPath);
		log.debug("URL Videogame Path: " + vidoegameUrlPath);
		return vidoegameUrlPath;
	}

	@Override
	public List<Videogame> searchAllGameInUserCollection( String query) {
		List<Videogame> videogamesSearchList= videogameRepository.searchAllGameInUserCollection(query);
		return videogamesSearchList;
	}

	@Override
	public List<Videogame> getLastVideogameAdded(int limit) {
		List<Videogame> videogamesSearchList= videogameRepository.getLastVideogamesAdded(limit);
		return videogamesSearchList;
	}

	@Override
	public List<Videogame> getVideogamesBySerie(int id) {
		return videogameRepository.getVideogamesBySerie(id);
	}
}

