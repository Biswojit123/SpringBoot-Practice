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
}
