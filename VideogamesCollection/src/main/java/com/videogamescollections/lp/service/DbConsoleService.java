package com.videogamescollections.lp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Console;
import com.videogamescollections.lp.repository.IConsoleRepository;


@Service("mainConsoleService")
public class DbConsoleService implements InterfacciaConsoleService {

	@Autowired
	private IConsoleRepository consoleRepository;
	
	@Override
	public Iterable<Console> getAll() {

		//return consoleRepository.findAllByOrderByNomeAsc();
		return consoleRepository.findAll();
	}
	
	@Override
	public Optional<Console> getById(int id) {
		
		return consoleRepository.findById(id);
	}
	
	@Override
	public Console create(Console console) {
		
		return consoleRepository.save(console);
	}
	
	@Override
	public Optional<Console> update(int id, Console console) {
		
		Optional<Console> foundConsole = consoleRepository.findById(id);
		
		if (foundConsole.isEmpty()) {
			
			return Optional.empty();
		}
		foundConsole.get().setNome(console.getNome());	
		foundConsole.get().setProduttore(console.getProduttore());
		foundConsole.get().setAnno(console.getAnno());
		consoleRepository.save(foundConsole.get());
		
		return foundConsole;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Console> foundConsole = consoleRepository.findById(id);
		
		if (foundConsole.isEmpty()) {
			
			return false;
		}
		
		consoleRepository.delete(foundConsole.get());
		
		return true;
	}
}

