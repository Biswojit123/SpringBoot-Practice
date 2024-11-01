package com.biswo.service;

import java.util.List;
import java.util.Optional;

import com.biswo.entity.Actors;

public interface InterActorsService {
	public String registerActor(Actors actor);
	public String updateActor(int id);
	public String registerActorsGroup(List<Actors> list);
	public Long countNumOfRecord();
	public Iterable<Actors> fetchAllActors();
	public boolean isIdExist(int id);
	public Iterable<Actors> fetchActorsById(Iterable<Integer> actor);
	public Optional<Actors> fetchActorById(int id);
	public Actors fetchsActorById(int id);
	//Partial Update by using id
	public String updateActorMobileNo(int id,Long mobileNum);
	//Fully Update By using Id of Actor
	public String updateActor(Actors actor);
	//Update actor if id exist other wise insert operation perform
	public String UpdateOrInsertIfExist(Actors actor);
	//Delete the record by id
	public String deleteActorById(int id);
	//delete Actor By passing the Direct Actor object
	public String deleteActor(Actors actor);
	//Remove actor by id
	public String removeActorById(int id);
	//remove all by id
	public String removeAllActors(List<Integer> ids);
	
	
}
