package com.videogamescollections.lp.repository;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			"vg.serie.nome like concat('%',:query, '%')" )
	List<Videogame> searchVideogamesBySeries(String query);
	
//	@Query("Select vg from Videogame vg " +
//			"left join owned_videogame ov on ov.videogame = vg.id " +
//			"where ov.user = 1 and " +
//			"vg.titolo like concat('%',:titolo, '%')" )
//	List<Videogame> searchAllGameInUserCollection(int userid, String titolo);
	
	//@Query(value="Select vg from Videogame vg where " +
		//	"left join owned_videogame ov on ov.videogame = vg.id " +
		//	"where ov.user = :userid and " +
		//	"vg.titolo like concat('%',:titolo, '%')", nativeQuery=true)
	@Query("Select vg from Videogame vg where " +
			"vg.titolo like concat('%',:query, '%')" )
	//List<Videogame> searchAllGameInUserCollection(int userid, String titolo);
	List<Videogame> searchAllGameInUserCollection(String query);
	
	@Query(value="Select * from videogame vg order by id desc limit :limit", nativeQuery = true) 
	List<Videogame> getLastVideogamesAdded(int limit);

	@Query(value="Select * from videogame vg where " +
			"vg.serie = :id" , nativeQuery = true)
	List<Videogame> getVideogamesBySerie(int id);
}
