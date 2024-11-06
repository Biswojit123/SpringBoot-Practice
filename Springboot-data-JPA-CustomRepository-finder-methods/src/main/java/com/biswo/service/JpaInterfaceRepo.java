package com.biswo.service;

import java.util.List;

import com.biswo.entity.Actors;

public interface JpaInterfaceRepo {
	public List<Actors> getActorByNameEqual(String name);
	public List<Actors> getActorByIdBetween(int start,int end);
	public Iterable<Actors> getActorByCategoryEqualsIgnoreCase(String category);
	public Iterable<Actors> getActorsByActorNameLike(String character);
}
