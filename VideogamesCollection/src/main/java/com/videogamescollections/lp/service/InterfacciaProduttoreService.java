package com.videogamescollections.lp.service;

import java.util.Optional;

import com.videogamescollections.lp.model.Produttore;

public interface InterfacciaProduttoreService {

	public Iterable<Produttore> getAll();

	public Optional<Produttore> getById(int id);

	public Produttore create(Produttore console);

	public Optional<Produttore> update(int id, Produttore console);

	public Boolean delete(int id);

}
