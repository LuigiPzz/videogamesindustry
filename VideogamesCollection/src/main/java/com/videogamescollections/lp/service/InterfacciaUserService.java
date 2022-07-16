package com.videogamescollections.lp.service;

import java.util.Optional;

import com.videogamescollections.lp.model.User;

public interface InterfacciaUserService {

	public Iterable<User> getAll();

	public Optional<User> getById(int id);

	public User create(User user);

	public Optional<User> update(int id, User user);

	public Boolean delete(int id);

}
