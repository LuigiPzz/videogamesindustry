package com.videogamescollections.lp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videogamescollections.lp.model.User;
import com.videogamescollections.lp.repository.IUserRepository;

@Service("mainUserService")
public class DbUserService implements InterfacciaUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public Iterable<User> getAll() {

		return userRepository.findAll();
	}

	@Override
	public Optional<User> getById(int id) {

		return userRepository.findById(id);
	}

	@Override
	public User create(User user) {

		return userRepository.save(user);
	}

	@Override
	public Optional<User> update(int id, User user) {

		Optional<User> foundUser = userRepository.findById(id);

		if (foundUser.isEmpty()) {

			return Optional.empty();
		}
		foundUser.get().setNome(user.getNome());
		foundUser.get().setCognome(user.getCognome());
		foundUser.get().setUsername(user.getUsername());
		foundUser.get().setPassword(user.getPassword());
		foundUser.get().setEmail(user.getEmail());
		userRepository.save(foundUser.get());

		return foundUser;
	}

	@Override
	public Boolean delete(int id) {

		Optional<User> foundUser = userRepository.findById(id);

		if (foundUser.isEmpty()) {

			return false;
		}

		userRepository.delete(foundUser.get());

		return true;
	}
}
