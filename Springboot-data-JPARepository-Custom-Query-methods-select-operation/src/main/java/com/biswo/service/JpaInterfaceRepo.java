package com.biswo.service;

import java.util.List;

import com.biswo.entity.Actors;
import com.biswo.view.View;

public interface JpaInterfaceRepo {
	public Iterable<Actors> findByActorName(String actorName);
	public Iterable<Actors> findAllActors();
	public <T extends View> List<T> findActorsByNameAndCategory(String actorName,String actorCategory,Class<T> clazz);
	public Iterable<Actors> findAllActors2(String category);
	public Iterable<Actors> findAllActors3(String role);
}
