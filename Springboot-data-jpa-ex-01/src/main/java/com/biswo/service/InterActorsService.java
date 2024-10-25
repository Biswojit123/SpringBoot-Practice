package com.biswo.service;

import java.util.List;

import com.biswo.entity.Actors;

public interface InterActorsService {
	public String registerActor(Actors actor);
	public String updateActor(int id);
	public String registerActorsGroup(List<Actors> list);
}
