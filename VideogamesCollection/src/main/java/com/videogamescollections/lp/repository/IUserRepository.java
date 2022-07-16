package com.videogamescollections.lp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videogamescollections.lp.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer>{

}
