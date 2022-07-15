package com.videogamescollections.lp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Console;
import com.videogamescollections.lp.repository.IConsoleRepository;


@Service("mainConsoleService")
public class DbConsoleService implements InterfacciaConsoleService {

	@Autowired
	private IConsoleRepository videogameRepository;
	
	@Override
	public Iterable<Console> getAll() {

		return videogameRepository.findAll();
	}
	
	@Override
	public Optional<Console> getById(int id) {
		
		return videogameRepository.findById(id);
	}
	
	@Override
	public Console create(Console Console) {
		
		return videogameRepository.save(Console);
	}
	
	@Override
	public Optional<Console> update(int id, Console console) {
		
		Optional<Console> foundConsole = videogameRepository.findById(id);
		
		if (foundConsole.isEmpty()) {
			
			return Optional.empty();
		}
		foundConsole.get().setNome(console.getNome());	
		foundConsole.get().setProduttore(console.getProduttore());
		foundConsole.get().setAnno(console.getAnno());
		videogameRepository.save(foundConsole.get());
		
		return foundConsole;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Console> foundConsole = videogameRepository.findById(id);
		
		if (foundConsole.isEmpty()) {
			
			return false;
		}
		
		videogameRepository.delete(foundConsole.get());
		
		return true;
	}
}

