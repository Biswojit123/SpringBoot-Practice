package com.biswo.repo;

import org.springframework.data.repository.CrudRepository;

import com.biswo.entity.Actors;

public interface IActorsRepository extends CrudRepository<Actors,Integer> {
	
}
