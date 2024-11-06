package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswo.entity.Actors;
import com.biswo.repository.JPARepositoryInter;

@Service
public class ImpleServiceRepo implements JpaInterfaceRepo {
	
	//Auto-wired the Repository
	@Autowired
	private JPARepositoryInter repo;

	@Override
	public List<Actors> getActorByNameEqual(String name) {
		//Pass the Actor Name
		//List<Actors> actors = repo.findByActorNameEquals(name);
		//List<Actors> actors = repo.findByActorNameIs(name);
		List<Actors> actors = repo.findByActorName(name);
		 return actors;
	}

	@Override
	public List<Actors> getActorByIdBetween(int start, int end) {
		
		return repo.findByActorIdBetween(start,end);
	}

	@Override
	public Iterable<Actors> getActorByCategoryEqualsIgnoreCase(String category) {
		return repo.findByActorCategoryEqualsIgnoreCase(category);
	}

	@Override
	public Iterable<Actors> getActorsByActorNameLike(String character) {
		//Iterable<Actors> actors = repo.findByActorNameLike(character);
		//Iterable<Actors> actors = repo.findByActorNameStartingWith(character);
		Iterable<Actors> actors = repo.findByActorNameContainingIgnoreCase(character);
		return actors;
	}
	
}
