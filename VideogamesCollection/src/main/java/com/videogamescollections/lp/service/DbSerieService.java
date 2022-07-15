package com.videogamescollections.lp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Serie;
import com.videogamescollections.lp.repository.ISerieRepository;


@Service("mainSerieService")
public class DbSerieService implements InterfacciaSerieService {

	@Autowired
	private ISerieRepository serieRepository;
	
	@Override
	public Iterable<Serie> getAll() {
		return serieRepository.findAll();
	}
	
	@Override
	public Optional<Serie> getById(int id) {
		
		return serieRepository.findById(id);
	}
	
	@Override
	public Serie create(Serie serie) {
		
		return serieRepository.save(serie);
	}
	
	@Override
	public Optional<Serie> update(int id, Serie serie) {
		
		Optional<Serie> foundSerie = serieRepository.findById(id);
		
		if (foundSerie.isEmpty()) {
			
			return Optional.empty();
		}
		foundSerie.get().setNome(serie.getNome());	
		serieRepository.save(foundSerie.get());
		
		return foundSerie;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Serie> foundSerie = serieRepository.findById(id);
		if (foundSerie.isEmpty()) {
			return false;
		}
		serieRepository.delete(foundSerie.get());
		return true;
	}
}

