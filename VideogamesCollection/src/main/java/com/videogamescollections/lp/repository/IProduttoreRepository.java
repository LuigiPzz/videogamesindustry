package com.videogamescollections.lp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videogamescollections.lp.model.Produttore;

@Repository
public interface IProduttoreRepository extends CrudRepository<Produttore, Integer> {

}
