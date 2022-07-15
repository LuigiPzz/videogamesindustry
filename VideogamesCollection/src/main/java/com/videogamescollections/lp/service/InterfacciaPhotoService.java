package com.videogamescollections.lp.service;

import java.util.Optional;

import com.videogamescollections.lp.model.Photo;

//metodi di idb service
public interface InterfacciaPhotoService {

	public Iterable<Photo> getAll();

	public Optional<Photo> getById(int id);

	public Photo create(Photo photo);

	public Optional<Photo> update(int id, Photo photo);

	public Boolean delete(int id);
}
