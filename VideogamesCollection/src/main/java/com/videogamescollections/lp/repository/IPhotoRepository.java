package com.videogamescollections.lp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videogamescollections.lp.model.Photo;

/**Photo è la classe che deve essere mappata alla tabella
 * integer è il tipo del campo chiave*/
@Repository
public interface IPhotoRepository extends CrudRepository<Photo, Integer> {

}
