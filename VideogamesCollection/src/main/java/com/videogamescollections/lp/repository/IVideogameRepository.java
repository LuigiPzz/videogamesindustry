package com.videogamescollections.lp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videogamescollections.lp.model.Videogame;

@Repository
public interface IVideogameRepository extends CrudRepository<Videogame, Integer> {

	@Query("Select vg from Videogame vg where " +
			"vg.titolo like concat('%',:query, '%')" )
	List<Videogame> searchVideogamesByTitle(String query);
	
	@Query("Select vg from Videogame vg where " +
			"vg.serie.titolo like concat('%',:query, '%')" )
	List<Videogame> searchVideogamesBySeries(String query);
}
