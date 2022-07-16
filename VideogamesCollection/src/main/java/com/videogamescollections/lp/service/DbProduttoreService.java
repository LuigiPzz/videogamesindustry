package com.videogamescollections.lp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.Produttore;
import com.videogamescollections.lp.repository.IProduttoreRepository;


@Service("mainProduttoreService")
public class DbProduttoreService implements InterfacciaProduttoreService {

	@Autowired
	private IProduttoreRepository produttoreRepository;
	
	@Override
	public Iterable<Produttore> getAll() {

		return produttoreRepository.findAll();
	}
	
	@Override
	public Optional<Produttore> getById(int id) {
		
		return produttoreRepository.findById(id);
	}
	
	@Override
	public Produttore create(Produttore produttore) {
		return produttoreRepository.save(produttore);
	}
	
	@Override
	public Optional<Produttore> update(int id, Produttore console) {
		
		Optional<Produttore> foundProduttore = produttoreRepository.findById(id);
		
		if (foundProduttore.isEmpty()) {
			
			return Optional.empty();
		}
		foundProduttore.get().setNome(console.getNome());	
		produttoreRepository.save(foundProduttore.get());
		
		return foundProduttore;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Produttore> foundProduttore = produttoreRepository.findById(id);
		
		if (foundProduttore.isEmpty()) {
			
			return false;
		}
		
		produttoreRepository.delete(foundProduttore.get());
		
		return true;
	}
}

