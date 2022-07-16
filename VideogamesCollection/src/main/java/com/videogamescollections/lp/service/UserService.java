package com.videogamescollections.lp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.User;

@Service
public class UserService implements InterfacciaUserService {

	private List<User> list;

	public UserService() {
		list = new ArrayList<User>();
	}

	@Override
	public Iterable<User> getAll() {
		return list;
	}

	@Override
	public Optional<User> getById(int id) {
		Optional<User> user = list.stream().filter(item -> item.getId() == id).findFirst();
		return user;
	}

	@Override
	public User create(User user) {
		list.add(user);
		return user;
	}

	@Override
	public Optional<User> update(int id, User user) {
		Optional<User> foundUser = list.stream().filter(item -> item.getId() == id).findFirst();
		if (foundUser.isEmpty()) {
			return Optional.empty();
		}
		foundUser.get().setNome(user.getNome());
		foundUser.get().setCognome(user.getCognome());
		foundUser.get().setUsername(user.getUsername());
		foundUser.get().setPassword(user.getPassword());
		foundUser.get().setEmail(user.getEmail());
		
		return foundUser;
	}

	@Override
	public Boolean delete(int id) {
		Optional<User> foundUser = list.stream().filter(item -> item.getId() == id).findFirst();
		if (foundUser.isEmpty()) {
			return false;
		}
		list.remove(foundUser.get());
		return true;
	}

}
