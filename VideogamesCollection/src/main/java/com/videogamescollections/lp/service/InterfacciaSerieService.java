package com.videogamescollections.lp.service;

import java.util.Optional;

import com.videogamescollections.lp.model.Serie;

public interface InterfacciaSerieService {

	public Iterable<Serie> getAll();

	public Optional<Serie> getById(int id);

	public Serie create(Serie serie);

	public Optional<Serie> update(int id, Serie serie);

	public Boolean delete(int id);

}
