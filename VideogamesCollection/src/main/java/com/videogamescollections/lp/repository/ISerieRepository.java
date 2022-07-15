package com.videogamescollections.lp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videogamescollections.lp.model.Serie;

@Repository
public interface ISerieRepository extends CrudRepository<Serie, Integer> {

}
