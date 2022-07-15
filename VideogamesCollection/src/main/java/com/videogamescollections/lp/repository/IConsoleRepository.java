package com.videogamescollections.lp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videogamescollections.lp.model.Console;

@Repository
public interface IConsoleRepository extends CrudRepository<Console, Integer> {

}
