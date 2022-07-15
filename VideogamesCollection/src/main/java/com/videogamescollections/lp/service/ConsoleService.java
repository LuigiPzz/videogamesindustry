package com.videogamescollections.lp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Console;

@Service
public class ConsoleService implements InterfacciaConsoleService {

	private List<Console> list;

	public ConsoleService() {
		list = new ArrayList<Console>();
		list.add(new Console(1, "Peppapig", 1, 1));
	}

	@Override
	public Iterable<Console> getAll() {
		return list;
	}

	@Override
	public Optional<Console> getById(int id) {
		Optional<Console> console = list.stream().filter(item -> item.getId() == id).findFirst();
		return console;
	}

	@Override
	public Console create(Console console) {
		list.add(console);
		return console;
	}

	@Override
	public Optional<Console> update(int id, Console console) {
		Optional<Console> foundConsole = list.stream().filter(item -> item.getId() == id).findFirst();
		if (foundConsole.isEmpty()) {
			return Optional.empty();
		}
		foundConsole.get().setNome(console.getNome());
		foundConsole.get().setProduttore(console.getProduttore());
		foundConsole.get().setAnno(console.getAnno());
		return foundConsole;
	}

	@Override
	public Boolean delete(int id) {
		Optional<Console> foundConsole = list.stream().filter(item -> item.getId() == id).findFirst();
		if (foundConsole.isEmpty()) {
			return false;
		}
		list.remove(foundConsole.get());
		return true;
	}

}
