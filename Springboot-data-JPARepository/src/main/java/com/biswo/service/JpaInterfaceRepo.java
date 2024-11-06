package com.biswo.service;

import java.util.List;

import com.biswo.entity.Actors;

public interface JpaInterfaceRepo {
	public String removeActorsByIdInBatch(List<Integer> ids);
	public Actors searchActorById(int id);
	public List<Actors> searchActorsByActor(Actors actor,boolean order,String ...properties);
}
